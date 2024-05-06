<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.jspProject.dto.ProductDTO" %>
<%@ page import="com.jspProject.dao.ProductDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body {
        font-family: 'Jua', sans-serif;
        background: linear-gradient(to bottom, #dbcce4 0%, #e2e2e2 100%);
        color: #ffffff;
        background-size: 400% 400%;
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0;
    }
    .container {
        padding: 40px;
        background: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        margin: 20px auto;
        max-width: 1200px;
        color: #000000;
    }
    .product-card {
        margin: 20px;
        padding: 20px;
        background-color: #f0f0f0; /* Light background for the card */
        border: 1px solid #ccc;
        border-radius: 10px;
        text-align: center;
        transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
        color: #000000; /* Set text color to black */
    }
    .product-image {
        height: 200px;
        width: auto;
        margin-bottom: 10px;
    }
    h5, p { /* Specific selectors for product names and prices */
        color: #000000; /* Set text color to black */
    }
    .btn-primary {
        transition: background-color 0.3s ease, box-shadow 0.3s ease;
    }
    .btn-primary:hover {
        background-color: #0056b3;
        box-shadow: 0 5px 10px rgba(0,0,0,0.2);
    }
    .product-card:hover {
        transform: scale(1.05);
        box-shadow: 0 8px 16px rgba(0,0,0,0.2);
    }
</style>
</head>
<body>
<div class="container">
    <h1>제품 목록</h1>
    <div class="row">
        <% 
            int categoryId = Integer.parseInt(request.getParameter("id"));
            List<ProductDTO> products = ProductDAO.getProductsByCategory(categoryId);
            for (ProductDTO product : products) {
                out.println("<div class='col-md-4'>");
                out.println("<div class='product-card'>");
                out.println("<img src='" + product.getImagePath() + "' alt='" + product.getName() + "' class='product-image'>");
                out.println("<h5>" + product.getName() + "</h5>");
                out.println("<p>" + product.getPrice() + "원" + "</p>");
                out.println("<a href='productDetail.jsp?productId=" + product.getId() + "' class='btn btn-primary'>상세 보기</a>");
                out.println("</div>");
                out.println("</div>");
            }
        %>
    </div>
</div>
</body>
</html>
