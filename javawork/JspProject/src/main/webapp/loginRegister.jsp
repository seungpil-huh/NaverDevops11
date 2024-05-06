<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 및 회원가입</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
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
            padding: 100px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            margin: 100px auto;
            max-width: 1000px;
        }
        h2, label {
            color: #333;
        }
        .form-control {
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .btn {
            border-radius: 5px;
            padding: 10px 15px;
            font-size: 16px;
            transition: all 0.2s;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .alert {
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- 추가된 안내문구 -->
    <div class="alert alert-info" role="alert">
        회원가입을 완료한 후 로그인해 주세요.
    </div>
    <div class="row">
        <div class="col-md-6">
            <h2>회원가입</h2>
            <form action="LoginRegisterServlet" method="post">
                <input type="hidden" name="action" value="register">
                <div class="mb-3">
                    <label>아이디:</label>
                    <input type="text" name="username" required class="form-control">
                </div>
                <div class="mb-3">
                    <label>비밀번호:</label>
                    <input type="password" name="password" required class="form-control">
                </div>
                <div class="mb-3">
                    <label>이메일:</label>
                    <input type="email" name="email" required class="form-control">
                </div>
                <div>
                    <button type="submit" class="btn btn-success">회원가입</button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <h2>로그인</h2>
            <form action="LoginRegisterServlet" method="post">
                <input type="hidden" name="action" value="login">
                <div class="mb-3">
                    <label>아이디:</label>
                    <input type="text" name="username" required class="form-control">
                </div>
                <div class="mb-3">
                    <label>비밀번호:</label>
                    <input type="password" name="password" required class="form-control">
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">로그인</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    <% if (request.getParameter("error") != null) { %>
        var error = "<%= request.getParameter("error") %>";
        var errorMessage = "";
        switch(error) {
            case "InvalidInput":
                errorMessage = "입력이 유효하지 않습니다.";
                break;
            case "PasswordShort":
                errorMessage = "비밀번호는 8자리 이상이어야 합니다!";
                break;
            case "UserExists":
                errorMessage = "계정이 이미 존재합니다.";
                break;
            case "InvalidLogin":
                errorMessage = "잘못된 계정입니다!";
                break;
            case "DatabaseError":
                errorMessage = "데이터베이스 오류가 발생했습니다.";
                break;
            default:
                errorMessage = "알 수 없는 오류가 발생했습니다.";
                break;
        }
        document.addEventListener('DOMContentLoaded', function () {
            var alertDiv = document.createElement('div');
            alertDiv.className = 'alert alert-danger';
            alertDiv.textContent = errorMessage;
            document.body.insertBefore(alertDiv, document.body.firstChild);
        });
    <% }
    if (request.getParameter("success") != null) { %>
        var successMessage = "회원가입을 축하합니다! 로그인해 주세요.";
        document.addEventListener('DOMContentLoaded', function () {
            var alertDiv = document.createElement('div');
            alertDiv.className = 'alert alert-success';
            alertDiv.textContent = successMessage;
            document.body.insertBefore(alertDiv, document.body.firstChild);
        });
    <% } %>
</script>
</body>
</html>
