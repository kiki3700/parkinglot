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
        <title>결제 페이지</title>
        <link rel="stylesheet" href="../resources/css/style.css">
    </head>
    <body>

        <div id="box">
            <h2>결제</h2>
            <label for="price">가격</label>
            <output>3,000</output><br>
            <label for="settlementTool">결제방법</label>
            <select name="settlementTool">
                <option>카드</option>
                <option>현금</option>
            </select><br>
            <input type="submit" value="결제"><br>
            <a href="javascript:history.back()"><button>뒤로가기</button></a>
        </div>
            
    </body>
</html>