<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jspProject.dto.ProductDetailDTO" %>
<%@ page import="com.jspProject.dao.ProductDetailDAO" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세</title>
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
        height: 100vh;
        display: flex;
        align-items: center; /* Aligns vertically */
        justify-content: center; /* Aligns horizontally */
        margin: 0;
    }
    .container {
        padding: 80px;
        background: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        margin: 20px auto;
        max-width: 1000px;
        display: flex;
        flex-direction: column;
        align-items: center; /* Aligns items to the center */
    }
    img {
        width: 100%; /* Full width of the container */
        max-width: 400px; /* Limits image size */
        margin-bottom: 50px;
    }
    h1, p, button {
        color: #000; /* Ensures text is black for visibility */
        margin-bottom: 20px;
        width: 100%; /* Full width of the container */
    }
    h1 {
        font-size: 40px;
        text-align: center;
    }
    p {
        font-size: 20px;
    }
    button {
        font-size: 20px; /* Increased font size */
        padding: 15px 50px; /* Adjust padding and make button narrower */
        margin-top: 30px; /* Increase spacing between the button and the last p tag */
    }
    #cart-icon {
        position: fixed;
        top: 20px;
        right: 20px;
        cursor: pointer;
        font-size: 50px;
        color: #000;
    }
    #cart-count {
        position: absolute;
        top: -10px;
        right: -10px;
        background-color: red;
        color: white;
        border-radius: 50%;
        padding: 5px 10px;
        font-size: 1.2rem;
    }
</style>
<script>
    $(document).ready(function() {
        var cartCount = sessionStorage.getItem('cartCount') || 0;
        $('#cart-count').text(cartCount);

        $('#cart-icon').click(function() {
            window.location.href = 'checkout.jsp'; // 결제 페이지로 이동
        });
    });

    function addToCart(productId) {
        $.ajax({
            url: 'addToCart.jsp',
            type: 'POST',
            data: { productId: productId },
            success: function(response) {
                var currentCount = parseInt(sessionStorage.getItem('cartCount') || 0) + 1;
                sessionStorage.setItem('cartCount', currentCount);
                $('#cart-count').text(currentCount);
                alert('장바구니에 추가되었습니다.');
            },
            error: function() {
                alert('장바구니 추가에 실패했습니다.');
            }
        });
    }
</script>
</head>
<body>
<div class="container">
    <% 
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDetailDTO product = ProductDetailDAO.getProductById(productId);
        if (product != null) {
            out.println("<h1>" + product.getName() + "</h1>");
            out.println("<img src='" + product.getImagePath() + "' alt='" + product.getName() + "'>");
            out.println("<p>가격: " + product.getPrice() + "원</p>");
            out.println("<p>설명: " + product.getDescription() + "</p>");
            out.println("<p>재고: " + product.getQuantity() + "개</p>");
            out.println("<button class='btn btn-primary' onclick='addToCart(" + product.getId() + ")'>장바구니에 담기</button>");
        } else {
            out.println("<p>제품 정보를 불러오는 데 실패했습니다.</p>");
        }
    %>
</div>
<div id="cart-icon">
    <i class="bi bi-cart4"></i>
    <span id="cart-count">0</span>
</div>
</body>
</html>
