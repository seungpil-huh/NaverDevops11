<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,com.jspProject.util.DBUtil" %>
<%@ page import="com.jspProject.dto.ProductDetailDTO" %>
<%@ page import="com.jspProject.dao.ProductDetailDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 추가</title>
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
session = request.getSession(true);
ArrayList<ProductDetailDTO> cartList = (ArrayList<ProductDetailDTO>) session.getAttribute("cart");

if (cartList == null) {
    cartList = new ArrayList<ProductDetailDTO>();
    session.setAttribute("cart", cartList);
}

int productId = Integer.parseInt(request.getParameter("productId"));
ProductDetailDTO productToAdd = ProductDetailDAO.getProductById(productId);

if (productToAdd != null && productToAdd.getQuantity() > 0) {
    // 장바구니 객체 생성 및 추가
    ProductDetailDTO cartProduct = new ProductDetailDTO();
    
    cartProduct.setId(productToAdd.getId());
    cartProduct.setName(productToAdd.getName());
    cartProduct.setPrice(productToAdd.getPrice());
    cartProduct.setQuantity(1); // 수량을 1로 설정
    cartProduct.setImagePath(productToAdd.getImagePath());
    cartProduct.setDescription(productToAdd.getDescription());
    
    cartList.add(cartProduct);
    session.setAttribute("cart", cartList);

    // tb_item 테이블의 quantity 업데이트
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement("UPDATE tb_item SET quantity = quantity - 1 WHERE id = ?");
        pstmt.setInt(1, productId);
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            out.println("제품이 장바구니에 추가되었습니다.");
        } else {
            out.println("제품 수량 갱신 실패.");
        }
    } catch (Exception e) {
        out.println("데이터베이스 오류: " + e.getMessage());
    } finally {
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
    }
} else {
    out.println("제품이 충분하지 않거나 장바구니에 추가하는 데 실패했습니다.");
}
%>
</body>
</html>