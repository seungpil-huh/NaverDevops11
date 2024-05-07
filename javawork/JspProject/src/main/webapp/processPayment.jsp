<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.jspProject.util.DBUtil" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.jspProject.dto.ProductDetailDTO" %>
<%@ page import="com.jspProject.dao.ProductDetailDAO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 처리</title>
</head>
<body>
<%
	double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
	session = request.getSession();
	ArrayList<ProductDetailDTO> cartList = (ArrayList<ProductDetailDTO>) session.getAttribute("cart");
	String username = (String) session.getAttribute("username");
	// 결제가 성공적으로 완료된 후 구매 목록을 세션에 저장
	ArrayList<ProductDetailDTO> purchases = new ArrayList<>(cartList);
	session.setAttribute("purchases", purchases); // 구매 목록을 세션에 저장
	
	if (cartList != null && !cartList.isEmpty()) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	        conn = DBUtil.getConnection();
	        conn.setAutoCommit(false); // Start transaction
	
	        // Update user points
	        pstmt = conn.prepareStatement("UPDATE tb_user SET point = point - ? WHERE username = ?");
	        pstmt.setDouble(1, totalAmount);
	        pstmt.setString(2, username);
	        int affectedRows = pstmt.executeUpdate();
	        pstmt.close();
	
	        if (affectedRows > 0) {
	            // Fetch new point balance from the database to update the session
	            pstmt = conn.prepareStatement("SELECT point FROM tb_user WHERE username = ?");
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                double newPoints = rs.getDouble("point");
	                session.setAttribute("point", newPoints);  // Update session with new point balance
	            }
	            rs.close();
	        }
	
	        // Update item quantities and clear cart
	        for (ProductDetailDTO item : cartList) {
	            pstmt = conn.prepareStatement("UPDATE tb_item SET quantity = quantity - ? WHERE id = ?");
	            pstmt.setInt(1, item.getQuantity());
	            pstmt.setInt(2, item.getId());
	            pstmt.executeUpdate();
	            pstmt.close();
	        }
	
	        conn.commit(); // Commit transaction
	        session.removeAttribute("cart"); // Clear cart in session
	        out.println("success");
	    } catch (Exception e) {
	        if (conn != null) try { conn.rollback(); } catch (SQLException ex) {} // Rollback on error
	        out.println("fail: " + e.getMessage());
	    } finally {
	        if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
	    }
	} else {
	    out.println("fail: Cart is empty or not available.");
	}
%>
</body>
</html>
