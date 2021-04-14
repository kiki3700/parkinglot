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
        <title>현금결제 구매</title>
        <link rel="stylesheet" href="../resources/css/style.css">
    </head>
    <body>
    <div id="box">
        <h2>현금 결제 구매</h2>
        <form name="settlementWithCash" action="/Parkinglot/Settlement" method="GET">
            <label for="cash">지불 하실 금액 :</label>
            <input id="cash" type="number" name="cash" required min="0" max="2147483647"><br>
            <label for="price">금액 :</label>
            <%= request.getParameter("price")%> 원<br>
            <label for="change">거스름 돈:</label>         
    		<a id="change"></a>
        <br>
        <input type="hidden" name="settlementTool" value="cash">
        <input type=hidden name="carNum" value="<%=request.getParameter("carNum") %>">
        <input type=hidden name="price" value="<%= request.getParameter("price") %>">
        <input type=hidden name="coupon" value="<%= request.getParameter("coupon") %>">
        <input class="star" type="submit" value="결제">
		<script>
		  var price= <%=Integer.valueOf(request.getParameter("price").toString())%>
		$(document).ready(function(){
			$("#cash").change(function(){
				$("#change").text($("#cash").val()-price);
			})
			$("form").submit(function(e){
			if($("#cash").val()-price<0){
			alert("금액이 부족합니다");
			e.preventDefault(e);
			}
			})
		})</script>                       
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a><br>
        <a href="/Parkinglot/index.jsp"><button>홈으로</button></a>
        </div>
    </body>
</html>