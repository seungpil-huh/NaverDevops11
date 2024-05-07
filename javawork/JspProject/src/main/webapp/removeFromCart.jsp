<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.jspProject.util.DBUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.jspProject.dto.ProductDetailDTO" %>
<%@ page import="com.jspProject.dao.ProductDetailDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 삭제</title>
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
ArrayList<ProductDetailDTO> cartList = (ArrayList<ProductDetailDTO>) session.getAttribute("cart");

if (cartList != null) {
    for (ProductDetailDTO item : cartList) {
        if (item.getId() == itemId) {
            cartList.remove(item);
            session.setAttribute("cart", cartList);
            
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                out.println("제품이 장바구니에서 삭제되었습니다.");
            } catch (Exception e) {
                out.println("데이터베이스 오류: " + e.getMessage());
            }
            break;
        }
    }
} else {
    out.println("장바구니가 비어있습니다.");
}
%>
</body>
</html>
