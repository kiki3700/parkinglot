<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

        <div id="box">
            <h2>결제가 완료 됐습니다.</h2>
			<label>티켓 시작일자 :</label> <p class="textbox"><%= request.getAttribute("beginOfTicket") %></p><br>
			<label>티켓 종료일자 : </label><p class="textbox"><%= request.getAttribute("endOfTicket") %></p><br>
			<label>차번호 : </label><p class="textbox"><%= request.getAttribute("carNum") %></p><br>
			<label>결제 수단 : </label><p class="textbox"><%= request.getAttribute("settlementTool") %></p><br>
			<label>금액 : </label><p class="textbox"><%= request.getAttribute("price") %>원</p><br>
            <a href="/Parkinglot/index.jsp"><button>홈으로</button></a>
        </div>

    </body>
</html>