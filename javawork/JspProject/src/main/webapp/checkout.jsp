<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.jspProject.util.DBUtil" %>
<%@ page import="com.jspProject.dto.ProductDetailDTO" %>
<%@ page import="com.jspProject.dao.ProductDetailDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
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
<div class="container mt-5">
    <h2>장바구니 목록</h2>
    <table class="table">
    <thead>
        <tr>
            <th>상품명</th>
            <th>가격</th>
            <th>수량</th>
            <th>총액</th>
            <th>작업</th>  <!-- 작업 열 추가 -->
        </tr>
    </thead>
    <tbody>
    <%
        session = request.getSession();
        ArrayList<ProductDetailDTO> cartList = (ArrayList<ProductDetailDTO>) session.getAttribute("cart");
        double total = 0;
        if (cartList != null) {
            for (ProductDetailDTO item : cartList) {
                double itemTotal = item.getPrice() * item.getQuantity();
                total += itemTotal;
                out.println("<tr><td>" + item.getName() + "</td><td>" + item.getPrice() + "</td><td>" + item.getQuantity() + "</td><td>" + itemTotal + "</td>");
                out.println("<td><button class='btn btn-danger delete-item' data-itemid='" + item.getId() + "'>삭제</button></td></tr>");
            }
        }
    %>
    </tbody>
</table>
    <div class="text-right">
        <h4>총 결제 금액: <%= total %>원</h4>
        <button class="btn btn-success">결제하기</button>
    </div>
</div>

<script>
$(document).ready(function() {
    $('.delete-item').on('click', function() {
        var itemId = $(this).data('itemid');
        var row = $(this).closest('tr');
        var itemQuantity = parseInt(row.find('td:eq(2)').text()); // 해당 행의 수량 추출
        
        $.ajax({
            url: 'removeFromCart.jsp',
            type: 'POST',
            data: { itemId: itemId },
            success: function(response) {
                alert('제품이 장바구니에서 삭제되었습니다.');
                row.remove();
                updateTotal();  // 총액 재계산
                updateCartCount(-itemQuantity);  // 카트 카운트 감소
            },
            error: function() {
                alert('제품 삭제 실패');
            }
        });
    });

    function updateTotal() {
        var total = 0;
        $('.table tbody tr').each(function() {
            total += parseFloat($(this).find('td').eq(3).text());  // 총액 열
        });
        $('.text-right h4').text('총 결제 금액: ' + total.toFixed(2) + '원');
    }

    function updateCartCount(delta) {
        var cartCount = parseInt(sessionStorage.getItem('cartCount') || '0');
        cartCount += delta;
        sessionStorage.setItem('cartCount', cartCount);
        $('#cart-count').text(cartCount);
    }
});
</script>

</body>
</html>