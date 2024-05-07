<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.jspProject.util.DBUtil" %>
<%@ page import="com.jspProject.dto.ProductDetailDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불 처리</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
    </style>
</head>
<body>
<%
	int itemId = Integer.parseInt(request.getParameter("itemId"));
	session = request.getSession();
	ArrayList<ProductDetailDTO> purchaseList = (ArrayList<ProductDetailDTO>) session.getAttribute("purchases");
	
	if (purchaseList != null) {
	    for (ProductDetailDTO item : purchaseList) {
	        if (item.getId() == itemId) {
	            Connection conn = null;
	            PreparedStatement pstmt = null;
	            try {
	                conn = DBUtil.getConnection();
	                conn.setAutoCommit(false); // Start transaction
	
	                // 포인트 업데이트
	                String username = (String) session.getAttribute("username");
	                double refundAmount = item.getPrice() * item.getQuantity();
	                pstmt = conn.prepareStatement("UPDATE tb_user SET point = point + ? WHERE username = ?");
	                pstmt.setDouble(1, refundAmount);
	                pstmt.setString(2, username);
	                pstmt.executeUpdate();
	                pstmt.close();
	
	                // 아이템 수량 업데이트
	                pstmt = conn.prepareStatement("UPDATE tb_item SET quantity = quantity + ? WHERE id = ?");
	                pstmt.setInt(1, item.getQuantity());
	                pstmt.setInt(2, itemId);
	                pstmt.executeUpdate();
	                pstmt.close();
	
	                // 세션 업데이트
	                pstmt = conn.prepareStatement("SELECT point FROM tb_user WHERE username = ?");
	                pstmt.setString(1, username);
	                ResultSet rs = pstmt.executeQuery();
	                if (rs.next()) {
	                    session.setAttribute("point", rs.getDouble("point"));
	                }
	                rs.close();
	
	                conn.commit(); // Commit transaction
	                purchaseList.remove(item); // Remove the refunded item from the list
	                session.setAttribute("purchases", purchaseList); // Update session
	                out.println("success");
	                break;
	            } catch (Exception e) {
	                if (conn != null) try { conn.rollback(); } catch (SQLException ex) {} // Rollback on error
	                out.println("fail: " + e.getMessage());
	            } finally {
	                if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
	                if (conn != null) try { conn.close(); } catch (SQLException ex) {}
	            }
	        }
	    }
	}
%>
</body>
</html>
