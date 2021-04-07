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
        <form>
            <h4>입차</h4>
            <label for="carNumber">차번호</label>
            <input type="text" name="carNumber"><br>
            <label for="carSize">차량 크기</label>
            <select name="carSize">
                <option value="small">중소형</option>
                <option value="big">대형</option>
            </select><br>
            <label for="enterTime">입차시간</label>
            <input type="datetime-local"><br>
            <input type="submit">
        </form>
        <h3>출차</h3>
        <form action="./calculator" method="GET">
            <label for="carNumber">차번호 :</label>
            <input type="text" name="carNumber"><br>
            <input type="submit">
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a>
    </div>
          
    </body>
