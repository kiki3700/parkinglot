<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="Class.Admin" %>
<%@page import ="Class.ParkingSpace" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/Parkinglot/resources/css/style.css">
        <title>티켓 구매 실패</title>
    </head>
    <body>
        <div id="box">
        <h2>이미 티켓을 소지하고 있습니다.</h2>
        <p> 티켓이 만료되면 다시 결제해 주시길 바랍니다.</p>
        <label>티켓 만료 일자 : <%=request.getAttribute("oldTicketEnd") %></label> 
        <br>
		<a href="/Parkinglot/index.jsp"><button>홈으로</button></a>
  	  </div>
  	 
    </body>

</html>