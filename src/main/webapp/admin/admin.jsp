<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="Class.Admin" %>
<%@page import ="Class.ParkingSpace" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../resources/css/style.css">
        <title>관리자 페이지</title>
    </head>
    <body>
    
    <div id="box">
    <h2>admin page</h2>
    <ul>
		<li>기기 작동여부 : <%= Admin.checkPos() %></li>
		<li>잔돈 량 :<br> 5000원 <%= Admin.getChange5000Balance() %>
		
		<br> 1000원 <%= Admin.getChange1000Balance() %>
		<br> 500원 <%= Admin.getChange500Balance() %>
		<br> 100원 <%= Admin.getChange100Balance() %>
		</li>


		<li>주차 가능 공간
		<br> 소형차 <%= ParkingSpace.small.getAvailableSpace() %>
		<br> 대형차 <%= ParkingSpace.big.getAvailableSpace() %>
		 </li>
		
    </ul>
    </div>
    </body>
</html>