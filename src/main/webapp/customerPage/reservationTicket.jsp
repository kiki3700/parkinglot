<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script
        src="https://code.jquery.com/jquery-3.6.0.js"
         integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
        <title>예약권 구매</title>
        <link rel="stylesheet" href="../resources/css/style.css">
    </head>
    <body>
    <div id="box">
        <h2>예약권 구매</h2>
        <form id="reservationTicketForm" name="reservastionTicketForm" action="./process.jsp" method="GET">
            <label for="carNumber">차량번호</label>
            <input type="text" name="carNumber"><br>
            <label for="beginOfTicket">예약일자</label>
            <input type="date" name="beginOfTicket">
            <input type="hidden" name="endOfTicket" value="1">
            <input type="hidden" name="sortOfTicket" value="reservation"><br>
            <button value="reservation">결제</button>
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a>
        <p>주의사항: 대형차량은 사무실을 통해서 예약해주시길 바랍니다. 사무실 전화번호 02-2601-8903</p>
        </div>
    </body>
</html>