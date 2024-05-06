<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jspProject.dao.CategoryDAO, com.jspProject.dto.CategoryDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 카테고리 선택</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body {
        font-family: 'Jua', sans-serif;
        background: linear-gradient(135deg, #9b5de5 0%, #f15bb5 50%, #fee440 100%);
        color: #ffffff;
        background-size: 400% 400%;
        display: flex;
        align-items: center; /* Aligns vertically */
        justify-content: center; /* Aligns horizontally */
        height: 100vh; /* Full viewport height */
        margin: 0;
    }
    .container {
        padding: 40px;
        max-width: 1200px; /* 너비 조정 */
        margin: auto;
        background: rgba(255, 255, 255, 0.8); /* 반투명 배경 */
        border-radius: 10px;
        display: flex; /* Ensures flex properties */
        flex-wrap: wrap; /* Allows multiple lines */
        justify-content: space-around; /* Distributes space between and around content lines */
        align-items: center; /* Centers items vertically inside the container */
    }
    h1 {
        color: #5a189a;
        text-align: center;
        width: 100%; /* Full width */
        margin-bottom: 30px;
    }
    .category-card {
        margin: 60px;
        width: 50%; /* Adjusts the width for 3 items per row */
        display: flex; /* Ensures proper alignment */
        justify-content: center; /* Center horizontally in the card */
    }
    .category-card a {
        color: #FFFFFF;
        background-color: #7b2cbf;
        display: block;
        padding: 20px;
        text-align: center;
        border-radius: 10px;
        width: 100%; /* Full width */
        transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
    }
    .category-card a:hover {
        background-color: #9b5de5;
        text-decoration: none;
        transform: scale(1.05);
        box-shadow: 0 8px 16px rgba(0,0,0,0.5);
    }
</style>
</head>
<body>
<div class="container">
    <h1>제품 카테고리 선택</h1>
    <div class="row">
        <% 
            List<CategoryDTO> categories = CategoryDAO.getAllCategories();
            for (CategoryDTO category : categories) {
                out.println("<div class='col-md-4 mb-4'>");
                out.println("<div class='category-card'>");
                out.println("<a href='products.jsp?id=" + category.getId() + "'>" + category.getName() + "</a>");
                out.println("</div></div>");
            }
        %>
    </div>
</div>
</body>
</html>
