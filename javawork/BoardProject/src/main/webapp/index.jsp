<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 페이지</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
    	@import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&family=Noto+Sans+KR:wght@400;500;700;900&family=Noto+Sans:wght@400;700&family=Orbitron:wght@800;900&family=Russo+One&display=swap");
    	
        body *{
            font-family: 'Jua';
        }
        
        html {
        /* 영문이면 roboto가 적용되고, 한글이면 Noto Sans KR가 적용되도록 아래와 같은 순서로 배치 */
        font-family: "Orbitron", sans-serif;
        font-family: "Noto Sans KR", sans-serif, "Noto Sans", sans-serif;
      }

      /* 노말라이즈 */
      body,
      ul,
      li,
      h1 {
        margin: 0;
        padding: 0;
        list-style: none;
      }

      a {
        color: inherit;
        text-decoration: none;
      }

      label[for] {
        cursor: pointer;
        user-select: none;
      }

      /* 라이브러리 */
      .block {
        display: block;
      }

      .inline-block {
        display: inline-block;
      }

      .absolute-left {
        position: absolute;
        left: 0;
      }

      .absolute-right {
        position: absolute;
        right: 0;
      }

      .absolute-bottom {
        position: absolute;
        bottom: 0;
      }

      .absolute-top {
        position: absolute;
        top: 0;
      }

      .absolute-center {
        position: absolute;
        left: 50%;
        transform: translateX(-50%);
      }

      .absolute-middle {
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
      }

      .absolute-middle.absolute-center {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translateX(-50%) translateY(-50%);
      }

      .relative {
        position: relative;
      }

      .cell {
        float: left;
        box-sizing: border-box;
      }

      .cell-right {
        float: right;
        box-sizing: border-box;
      }

      .row::after {
        content: "";
        display: block;
        clear: both;
      }

      .clear-both {
        clear: both;
      }

      .img-box > img {
        width: 100%;
        display: block;
      }

      .con {
        margin-left: auto;
        margin-right: auto;
      }

      .margin-0-auto {
        margin-left: auto;
        margin-right: auto;
      }

      .text-align-center {
        text-align: center;
      }

      .text-align-right {
        text-align: right;
      }

      .line-height-0 {
        line-height: 0;
      }

      .line-height-0 > * {
        line-height: normal;
      }

      .width-30px {
        width: 30px;
      }

      .width-35px {
        width: 35px;
      }

      .width-40px {
        width: 35px;
      }

      .width-45px {
        width: 35px;
      }

      .width-50px {
        width: 50px;
      }

      .width-80px {
        width: 80px;
      }

      .width-100px {
        width: 100px;
      }

      .width-100p {
        width: 100%;
      }

      .width-60p {
        width: 60%;
      }

      .width-55p {
        width: 55%;
      }

      .width-50p {
        width: 50%;
      }

      .width-45p {
        width: 45%;
      }

      .width-40p {
        width: 40%;
      }

      .width-30p {
        width: 30%;
      }

      .width-35p {
        width: 35%;
      }

      .width-100p-except-30px {
        width: calc(100% - 30px);
      }

      .width-100p-except-35px {
        width: calc(100% - 35px);
      }

      .width-100p-except-40px {
        width: calc(100% - 40px);
      }

      .width-100p-except-50px {
        width: calc(100% - 50px);
      }

      .width-100p-except-80px {
        width: calc(100% - 80px);
      }

      .width-100p-except-100px {
        width: calc(100% - 100px);
      }

      .height-100vh {
        height: 100vh;
      }
      .height-100p {
        height: 100%;
      }

      .height-50p {
        height: 50%;
      }

      .border-box {
        box-sizing: border-box;
      }

      .font-size-dot-8rem {
        font-size: 0.8rem;
      }

      .table-row {
        display: table;
      }

      .table-row.row::after {
        display: inline;
        clear: non;
      }

      .table-row > .cell {
        float: none;
        display: table-cell;
      }

      .border-red {
        border: 10px solid red;
      }

      .border-green {
        border: 10px solid green;
      }

      .border-blue {
        border: 10px solid blue;
      }

      .border-gold {
        border: 10px solid gold;
      }

      .border-pink {
        border: 10px solid pink;
      }

      /* 라이브러리 - flex */
      * > .flex {
        display: flex;
      }

      * > .flex-grow-1 {
        flex-grow: 1;
      }

      * > .flex-jc-c {
        justify-content: center;
      }

      * > .flex-jc-s {
        justify-content: flex-start;
      }

      * > .flex-jc-e {
        justify-content: flex-end;
      }

      * > .flex-jc-sa {
        justify-content: space-around;
      }

      * > .flex-jc-sb {
        justify-content: space-between;
      }

      * > .flex-ai-c {
        align-items: center;
      }

      * > .flex-ai-s {
        align-items: flex-start;
      }

      * > .flex-ai-e {
        align-items: flex-end;
      }

      * > .flex-as-s {
        align-self: stretch;
      }

      * > .flex-as-c {
        align-self: center;
      }

      * > .flex-as-s {
        align-self: flex-start;
      }

      * > .flex-as-e {
        align-self: flex-end;
      }

      * > .flex-wrap-wrap {
        flex-wrap: wrap;
      }

      * > .flex-wrap-no {
        flex-wrap: nowrap;
      }

      * > .flex-column-nowrap {
        flex-flow: column nowrap;
      }

      * > .flex-column-wrap {
        flex-flow: column wrap;
      }

      * > .flex-row-wrap {
        flex-flow: row wrap;
      }

      .flex-ch-basis-0 > * {
        flex-basis: 0;
      }

      * > .flex-1-0-0 {
        flex: 1 0 0;
      }
      .con {
        max-width: 1080px;
      }
      .popup-bg {
        position: fixed; /* fixed 또는 absolute로 설정하여 화면 전체를 채울 수 있도록 합니다 */
	    top: 0;
	    left: 0;
	    right: 0;
	    bottom: 0;
	    background-color: #000;
	    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	    height: 100vh; /* 브라우저 창의 전체 높이를 채우도록 설정 */
	    width: 100vw; /* 필요한 경우 추가하여 너비 또한 전체를 채우도록 설정 */
      }
      .section {
        height: 100vh;
        color: #fff;
        position: relative;
      }
      .text-box {
        text-align: center;
        font-weight: bold;
      }
      .text-box .title {
        padding-top: 300px;
        font-size: 100px;
      }
      .text-box .txt-1 {
        padding-top: -20px;
        font-size: 50px;
      }
      .text-box .txt-2 {
        padding-top: 40px;
        font-size: 20px;
        font-weight: 700;
      }
      .popup-bg .scroll-guide {
        text-align: center;
        left: 50%;
        bottom: 50px;
        padding: 10px;
        transform: translateX(-50%);
        border: 2px solid #fff;
        border-radius: 10px;
        box-sizing: border-box;
        cursor: pointer;
        position: absolute;
      }
      .fas {
        font-weight: bold;
        color: #fff;
      }
      .fa-angle-double-down::before {
        content: "\f103";
      }
    </style>
</head>
<body>
<link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700;900&family=Roboto:wght@400;700;900&display=swap"
      rel="stylesheet"
    />

    <!-- 폰트어썸 불러오기 -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
    />

    <!-- 제이쿼리 불러오기 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <div class="popup-bg">
      <div class="section">
        <div class="text-box">
          <p class="title">게시판 프로젝트</p>
          <p class="txt-1">네이버클라우드</p>
          <p class="txt-2">데브옵스 11기 허승필</p>
        </div>
        <div class="scroll-guide">
          <i class="fas fa-angle-double-down"></i>
          <div class="click">로그인</div>
        </div>
      </div>
    </div>

    <script>
      /* scroll-guide-btn moving jQuery */
      function guide() {
        $(document).ready(function () {
          $(".popup-bg>.section>.scroll-guide").animate(
            {
              bottom: 55 + "px",
            },
            400,
            function () {
              $(".popup-bg>.section>.scroll-guide").animate(
                {
                  bottom: 50 + "px",
                },
                400,
                guide
              );
            }
          );
        });
      }
      $(function () {
        guide();
      });

      $(function () {
        var $show = $(".show");
        var $hide = $(".hide");
        var $box = $(".box");
        $(".fas").click(function () {
          $(".popup-bg").slideDown();
        });
        $(".fas,.click").click(function () {
          $(".popup-bg").slideUp();
        });
      });

      $(".popup-bg").slideDown();
      
      $(document).ready(function() {
    	    $(".click").click(function() {
    	        $(".popup-bg").slideUp(500, function() {
    	            window.location = "login.jsp"; // 슬라이드 업 효과 후 페이지 전환
    	        });
    	    });
    	});
    </script>
</body>
</html>
