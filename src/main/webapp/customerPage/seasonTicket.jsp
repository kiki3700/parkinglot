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
        <title>정기권 구매</title>
        <link rel="stylesheet" href="../resources/css/style.css">
    </head>
    <body>
    <div id="box">
        <h2>정기권 구매</h2>
        <form id="reservationTicketForm" name="reservastionTicketForm" action="./process.jsp" method="GET">
            <label for="carNum">차량번호 : </label>
            <input type="text" name="carNumber" required><br>
            <label for="beginOfTicket">정기권 시작 일자 : </label>
            <input type="date" name="beginOfTicket" required><br>
            <label for="seasonTicketList" >정기권 리스트 : </label>
            <select  name="period" required>
                <option value="30">한달</option>
                <option value="60">두달</option>
                <option value="180">육개월</option>
                <option value="365">일년권</option>
            </select><br>
            <label for="adaptFromNow">당일 적용 여부</label>
             <input type="checkbox" name="adaptFromNow" value="true"><br>
            <input type="hidden" name="sortOfTicket" value="seasonTicket">
            <button value="reservation">결제</button>
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a>
        <p>주의사항: 대형차량은 정기권 구매가 불가능합니다. 사무실 전화번호 02-2601-8903</p>
        </div>
    </body>
</html>
    