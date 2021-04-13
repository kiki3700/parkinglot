<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="Class.ParkingSpace" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./resources/css/style.css">
        <title>index</title>
    </head>
    	
    <body>   

    <div id="box">
    <h2>welcome to Sanai parkinglot!</h2>
    <p><strong>사나이</strong> 주차장에 오신걸 환영 합니다.</p>
	<div>현재 주차 가능 공간
	<br>소형차 : <p class="textbox"><%= ParkingSpace.small.getAvailableSpace() %></p>
	<br> 대형차 : <p class="textbox"><%= ParkingSpace.big.getAvailableSpace() %></p>
	</div>
        <a href="./customerPage/customerPOS.jsp"><button>무인 계산기</button></a><br>
        <a href="./simulator.jsp"><button>시뮬레이터</button></a><br>
        <a href="./settlerPage/settler.jsp"><button>정산원</button></a><br>
        <a href="./admin/admin.jsp"><button>관리자</button></a>
    </div>
    </body>
</html>