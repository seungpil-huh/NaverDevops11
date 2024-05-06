<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>환영합니다! 이커머스 사이트</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet"> <!-- Jua font 추가 -->
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body {
            font-family: 'Jua', sans-serif; /* Jua 폰트 적용 */
            background: linear-gradient(to bottom, #dbcce4 0%, #e2e2e2 100%);
            padding-top: 40px;
            color: #333;
        }
        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 80px; /* 패딩 증가 */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.15);
            max-width: 1000px; /* 너비 증가 */
            margin: auto;
        }
        h1 {
            color: #5a189a;
            margin-bottom: 40px;
            font-size: 40px; /* 헤더 크기 증가 */
        }
        p {
            font-size: 25px; /* 텍스트 크기 증가 */
            line-height: 1.8;
        }
        .btn-primary {
            background-color: #9b5de5;
            border-color: #9b5de5;
            width: 100%;
            padding: 20px; /* 버튼 패딩 증가 */
            font-size: 25px; /* 버튼 폰트 크기 증가 */
            margin-top: 30px;
            transition: background-color 0.3s, transform 0.3s;
        }
        .btn-primary:hover {
            background-color: #7b2cbf;
            border-color: #7b2cbf;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(123,44,191,0.4);
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h1>이커머스 플랫폼에 오신 것을 환영합니다!</h1>
    <p>저희 이커머스 플랫폼은 최신 패션, 가전 제품, 생활 용품 등 다양한 카테고리의 상품을 제공하는 최적의 온라인 쇼핑 몰입니다. 사용자 편의를 최우선으로 생각하며, 안전하고 신뢰할 수 있는 쇼핑 환경을 제공하기 위해 노력합니다.</p>
    <p>회원가입을 통해 저희 사이트의 다양한 혜택과 서비스를 경험하세요. 회원가입 과정은 간단하며, 회원으로 등록하시면 새로운 상품 소식, 특별 할인, 이벤트 정보 등을 이메일로 받아보실 수 있습니다.</p>
    <p>또한, 저희 사이트는 사용자 리뷰를 통해 상품의 품질을 확인할 수 있으며, 다양한 결제 옵션을 제공하여 편리하게 쇼핑하실 수 있습니다.</p>
    <a href="loginRegister.jsp" class="btn btn-primary">로그인 / 회원가입</a>
</div>
</body>
</html>
