<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="Class.Time" %>
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
        <form id="reservationTicketForm" name="reservastionTicketForm" action="/Parkinglot/checkCarInfo" method="GET">
            <label for="carNum">차량번호 : </label>
            <input type="number" name="carNum" required min=1000 max=9999><br>
            <label for="beginOfTicket">정기권 시작 일자 : </label>
            <input type="date" name="beginOfTicket" required min="<%= LocalDate.now().format(Time.formatterForDate) %>"><br>
            <label for="seasonTicketList" >정기권 리스트 : </label>
            <select  name="period" required>
                <option value="30">한달</option>
                <option value="60">두달</option>
                <option value="180">육개월</option>
                <option value="365">일년권</option>
            </select><br>
            <label for="adaptFromNow">당일 적용 여부 :</label>
             Y <input type="radio"  name="adaptFromNow"  value="true" checked> 
               N <input type="radio"  name="adaptFromNow"  value="false">
        <br>
            <input type="hidden" name="sortOfTicket" value="seasonTicket">
            <button value="reservation">다음</button>
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a>
        <p>주의사항: 대형차량은 정기권 구매가 불가능합니다. 사무실 전화번호 02-2601-8903</p>
        </div>
    </body>
</html>
    