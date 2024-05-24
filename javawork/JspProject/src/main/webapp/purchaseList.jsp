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
<title>구매 목록</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
        table {
		    width: 100%;
		    border-collapse: collapse;
		    margin: 20px 0;
		}
		th, td {
		    padding: 15px;
		    text-align: left;
		    border-bottom: 1px solid #ddd;
		}
		.btn-danger {
		    background-color: red;
		    border: none;
		    cursor: pointer;
		}
		.btn-danger:hover {
		    background-color: darkred;
		}
    </style>
</head>
<body>
<div class="container mt-5">
    <h2>구매 목록</h2>
    <table class="table">
    <thead>
        <tr>
            <th>상품명</th>
            <th>가격</th>
            <th>수량</th>
            <th>총액</th>
            <th>작업</th>
        </tr>
    </thead>
    <tbody>
    <%
	    session = request.getSession();
	    ArrayList<ProductDetailDTO> purchaseList = (ArrayList<ProductDetailDTO>) session.getAttribute("purchases");
	    if (purchaseList != null && !purchaseList.isEmpty()) {
	        for (ProductDetailDTO item : purchaseList) {
	            out.println("<tr><td>" + item.getName() + "</td><td>" + item.getPrice() + "</td><td>" + item.getQuantity() + "</td><td>" + (item.getPrice() * item.getQuantity()) + "</td>");
	            out.println("<td><button type='button' class='btn btn-danger' onclick='refundItem(" + item.getId() + ")'>환불하기</button></td></tr>");
	        }
	    } else {
	        out.println("<tr><td colspan='5'>구매 목록이 비어 있습니다.</td></tr>");
	    }
	%>
    </tbody>
</table>
</div>

<script>
function refundItem(itemId) {
    $.ajax({
        url: 'refundItem.jsp',
        type: 'POST',
        data: { itemId: itemId },
        success: function(response) {
            alert('환불 처리되었습니다.');
            location.reload();  // 페이지를 다시 로드하여 업데이트된 목록을 보여줍니다.
        },
        error: function() {
            alert('환불 실패');
        }
    });
}
</script>
</body>
</html>
