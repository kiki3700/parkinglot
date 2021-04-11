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
        <ul id="box">
        <h2>admin</h2>
			<li>기기 작동여부 : <%= Admin.checkPos() %></li>
			<li>기기 스위치<a href="/Parkinglot/machinSwitch"> <button>click</button></a></li>
			<li>잔돈 량 :<br> 5000원 <%= Admin.getChange5000Balance() %>
			
			<br> 1000원 <%= Admin.getChange1000Balance() %>
			<br> 500원 <%= Admin.getChange500Balance() %>
			<br> 100원 <%= Admin.getChange100Balance() %>		
			</li>
			<li>잔돈 채우기 
			<form action="/Parkinglot/RefillChage" method="GET">
			<select name="change">
				<option value="50000">50000</option>
				<option value="1000">10000</option>
				<option value="500">5000</option>
				<option value="100">100</option>
			</select>
			<input type="number" name="amount" required>
			<input type="submit" value="click">
			</form>
			</li>
			<li>주차 가능 공간
			<br> 소형차 <%= ParkingSpace.small.getAvailableSpace() %>
			<br> 대형차 <%= ParkingSpace.big.getAvailableSpace() %>
			 </li>
			 <li>주차 공간 조절
			 <form action="/Parkinglot/ParkingSpaceOperation" method="get">
			 <select name="size">
			 	<option value="big">big</option>
			 	<option value="small">small</option>
			 </select>
			 <input type="submit" name="operator" value="plus">
			  <input type="submit" name="operator" value="minus">
			 </form>
			 <br>
			  <a href="/Parkinglot/index.jsp"><button>홈으로</button></a>
  	  </ul>
  	 
    </body>

</html>