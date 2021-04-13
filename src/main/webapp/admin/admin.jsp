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
			<li>기기 작동여부 : <p class="textbox"><%= Admin.checkPos() %></p></li>
			<li>기기 스위치 : <a href="/Parkinglot/machinSwitch"> <button>click</button></a></li>
			<li>잔돈 량 :<br> 5000원 : <p class="textbox"><%= Admin.getChange5000Balance() %></p>			
			<br> 1000원 : <p class="textbox"><%= Admin.getChange1000Balance() %></p>
			<br> 500원 : <p class="textbox"><%= Admin.getChange500Balance() %></p>
			<br> 100원 : <p class="textbox"><%= Admin.getChange100Balance() %></p>		
			</li>
			<li>잔돈 채우기 
			<form action="/Parkinglot/RefillChage" method="GET">
			<select name="change">
				<option value="5000">5000</option>
				<option value="1000">1000</option>
				<option value="500">500</option>
				<option value="100">100</option>
			</select>
			<input type="number" name="amount" required>
			<input class="star" type="submit" value="click">
			</form>
			</li>
			<li>주차 가능 공간
			<br> 소형차 : <p class="textbox"><%= ParkingSpace.small.getAvailableSpace() %></p>
			<br> 대형차 : <p class="textbox"><%= ParkingSpace.big.getAvailableSpace() %></p>
			 </li>
			 <li>주차 공간 조절
			 <form action="/Parkinglot/ParkingSpaceOperation" method="get">
			 <select name="size">
			 	<option value="big">big</option>
			 	<option value="small">small</option>
			 </select>
			 <input class="star" type="submit" name="operator" value="plus">
			  <input class="star" type="submit" name="operator" value="minus">
			 </form>
			 <br>
			  <a href="/Parkinglot/index.jsp"><button>홈으로</button></a>
  	  </ul>
  	 
    </body>

</html>