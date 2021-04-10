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
		<link rel="stylesheet" href="./resources/css/style.css">	
        <title>simulator</title>
    </head>
    <body>
        

    <div id="box">
    <h2>시뮬레이터</h2>
        <h3>입차 출차 관련</h3>

            <h4>입차</h4>
            <form action="/Parkinglot/simulationEnter" method="GET">
            <label for="carNum">차번호</label>
            <input type="text" name="carNum" required><br>
            <label for="carSize" >차량 크기</label>
            <select name="carSize" required>
                <option value="small">중소형</option>
                <option value="big">대형</option>
            </select><br>
            <label for="enterTime">입차시간</label>
            <input type="date" name="date" required> <input type="time"  name="time" required><br>
            <input type="submit" value="제출"><br>
            <% String a="";
            		if(request.getAttribute("result")!=null){
            			a=request.getAttribute("result").toString();
            		}
            		%>
            <%= a %>

            
        </form>
        <h3>출차</h3>
        <form action="/Parkinglot/simulationExit" method="GET">
            <label for="carNum">차번호 :</label>
            <input type="text" name="carNum"><br>
             <label for="enterTime">출차 시간</label>
            <input type="date" name="date" required> <input type="time"  name="time" required><br>
            <input type="submit" value="제출">
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a>
    </div>
          
    </body>
