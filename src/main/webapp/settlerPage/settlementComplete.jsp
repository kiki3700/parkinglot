<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Class.Ticket"%>
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script
                src="https://code.jquery.com/jquery-3.6.0.js"
                 integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
                crossorigin="anonymous"></script>
        <title>결제 페이지</title>
        <link rel="stylesheet" href="/Parkinglot/resources/css/style.css">
    </head>
    <body>
    	<div class="changebutton">admin</div>
        <div id="box">
            <h2>결제가 완료 됬습니다.</h2>
			<label>차번호 : </label><p class="textbox"><%= request.getAttribute("carNum") %></p><br>
			<label>금액 : </label><p class="textbox"><%= request.getAttribute("price") %>원</p><br>
			<label>최종결제금액 : </label><p class="textbox"><%= request.getAttribute("finalPrice") %>원</p><br>
			<label>결제수단 : </label><p class="textbox"><%= request.getAttribute("settlementTool") %></p><br>
            <a href="/Parkinglot/index.jsp"><button>홈으로</button></a>
        </div>

    </body>
</html>