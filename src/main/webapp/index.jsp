<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="Class.Admin" %>
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
    <h2>welcome to index page!</h2>
    <p>주의 차번호는 4자릿 수 숫자를 권장합니다.</p>
    <ul>
        <li><a href="./customerPage/customerPOS.jsp">무인 계산기</a></li>
        <li><a href="./simulator.jsp">시뮬레이터</a></li>
        <li><a href="./settlerPage/settler.jsp">정산원</a></li>
        <li><a href="./admin/admin.jsp">관리자</a></li>
    </ul>
    </div>
    </body>
</html>