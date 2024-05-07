<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jspProject.dao.CategoryDAO, com.jspProject.dto.CategoryDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jspProject.dto.UserDTO" %>
<%@ page import="com.jspProject.dao.UserDAO" %>
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
        background-size: 400% 400%;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
        position: relative;
    }
    .container {
        padding: 40px;
        max-width: 1200px;
        margin: auto;
        background: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        align-items: center;
    }
    h1 {
        color: #5a189a;
        text-align: center;
        width: 100%;
        margin-bottom: 30px;
    }
    .category-card {
        margin: 60px;
        width: 50%;
        display: flex;
        justify-content: center;
    }
    .category-card a {
        color: #FFFFFF;
        background-color: #7b2cbf;
        display: block;
        padding: 20px;
        text-align: center;
        border-radius: 10px;
        width: 100%;
        transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
    }
    .category-card a:hover {
        background-color: #9b5de5;
        text-decoration: none;
        transform: scale(1.05);
        box-shadow: 0 8px 16px rgba(0,0,0,0.5);
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
    .top-left-button {
        position: fixed;
	    top: 30px;
	    left: 30px;
	    z-index: 1001;
	    width: auto; /* 자동으로 내용에 맞게 크기 조정 */
	    padding: 10px 10px; /* 버튼 내부 여백을 추가하여 시각적으로 더 좋게 만듬 */
	    border: none;
	    border-radius: 10px;
    }
    .user-info {
        position: fixed;
	    top: 0;
	    right: -33%; /* 초기 상태에서는 패널이 보이지 않도록 설정 */
	    width: 33%;
	    height: 100%;
	    background-color: rgba(255,255,255,0.9);
	    padding: 20px;
	    transition: right 0.5s; /* 애니메이션 효과 */
	    z-index: 1000;
    }
    .greeting {
        font-size: 48px;
        margin-bottom: 100px;
    }
    .points-info {
    	font-size: 24px;
    	margin-top: 5px;
	}
	.dark-purple {
	    color: #5a189a; /* 진한 보라색 */
	    font-weight: bold; /* 굵은 글씨체 */
	}
	.light-purple {
	    color: #9b5de5; /* 연보라색 */
	}
</style>
<script>
	function toggleUserInfo() {
		var userInfo = document.getElementById('user-info');
	    if (userInfo.style.right == '0px' || userInfo.style.right == '') {
	        userInfo.style.right = '-33%'; // 패널을 오른쪽으로 밀어내어 숨깁니다.
	    } else {
	        userInfo.style.right = '0px'; // 패널을 화면으로 가져옵니다.
	    }
	}
</script>
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
<button class="btn btn-primary top-left-button" onclick="toggleUserInfo()">
    <i class="bi bi-person-fill"></i> 회원정보
</button>
<div id="user-info" class="user-info">
    <% 
    session = request.getSession(false); // 세션이 존재하지 않으면 null 반환
    if (session != null) {
        String nickname = (String) session.getAttribute("nickname");
        Double point = (Double) session.getAttribute("point");
        if (nickname != null) {
        	out.println("<h2 class='greeting light-purple'>안녕하세요 <span class='dark-purple'>" + nickname + "</span> 님!</h2>");
            out.println("<p class='points-info light-purple'><span class='dark-purple'>" + nickname + "</span> 님의 남은 포인트는 <span class='dark-purple'>" + String.format("%,.2f", point) + "</span> 원 입니다.</p>");
        }
    }
    %>
</div>
<div id="cart-icon">
    <i class="bi bi-cart4"></i>
    <span id="cart-count">0</span>
</div>
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
