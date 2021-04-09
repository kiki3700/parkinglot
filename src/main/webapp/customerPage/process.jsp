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
        <link rel="stylesheet" href="../resources/css/style.css">
    </head>
    <body>

        <div id="box">
            <h2>결제</h2>
            <form action="/Parkinglot/TicketSettlement" >
            <% String period = request.getParameter("period"); %>
          	 <label for="price">선택 상품 </label>
          	 <%= Ticket.getTicketName(Integer.parseInt(period)) %><br>
       		  <label for="price">가격</label>
           <%= Ticket.getTicketPrice(Integer.parseInt(period))%>원<br>
            <label for="settlementTool">결제방법</label>
            <select name="settlementTool">
                <option value="card">카드</option>
                <option value="cash">현금</option>
            </select><br>
            <input type="submit" value="결제"><br>
            </form>
            <a href="javascript:history.back()"><button>뒤로가기</button></a>
        </div>
            
    </body>
</html>