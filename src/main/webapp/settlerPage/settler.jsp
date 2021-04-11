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
        <link rel="stylesheet" href="/Parkinglot/resources/css/style.css">
        <title>autoinput</title>
    </head>
    <body>
    	<div id="box">
        	<h2>정산원 페이지</h2>
        	<form id="settle" action="/Parkinglot/Settlement" method="GET">
        	<label>차번호 : </label><%= request.getAttribute("carNum") %><br>
	        <label>요금 : </label><%= request.getAttribute("price") %> <br>
	        <label>입차시간 : </label><%= request.getAttribute("enterTime") %> <br>
	        <label>출차시간 : </label><%= request.getAttribute("exitTime") %> <br>
	        <label>쿠폰 여부 : </label>
        	<select name="coupon">
	       		 <option value="no"></option>
	       		 <option value="absolute">쿠폰 a</option>
	         	<option value="relative">쿠폰 b</option>
	        </select><br>
	        <label>결제도구 :</label>
	        <select id="settlementTool" name="settlementTool">
	        	<option value ="card">카드</option>
	        	<option value = "cash">현금</option>
	        </select><br>
	        <input type="hidden" name="carNum" value="<%= request.getAttribute("carNum") %>">
	        <input type="hidden" name="price" value="<%= request.getAttribute("price") %>">
	         <input type="hidden" name="cash" value="0">
	        <input type="submit">
	        </form>
	        <script>
            $(document).ready(function(){
            	$("#settlementTool").change(function() {
            		console.log($(".settlementTool option:selected").val());
            		
    				if($("#settlementTool option:selected").val()=="cash"){
    					$("#settle").attr("action","/Parkinglot/settlerPage/settleWithCash.jsp");
    					console.log($(".settlementTool option:selected").val());
    				}
    				if($("#settlementTool option:selected").val()=="card"){
    					$("#settle").attr("action","/Parkinglot/Settlement");
    					console.log($(".settlementTool option:selected").val());
    				}
            	})
            });

            </script>
        	<a href="javascript:history.back()"><button>뒤로가기</button></a>
	    </div>
    </body>
</html>