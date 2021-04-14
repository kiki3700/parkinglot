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
        <title>예약권 구매</title>
        <link rel="stylesheet" href="../resources/css/style.css">
    </head>
    <body>
    <div id="box">
        <h2>예약권 구매</h2>
        <form name="settlementWithCash" action="/Parkinglot/TicketSettlement" method="GET">
            <label for="cash">지불 하실 금액 :</label>
            <input id="cash" type="number" name="cash" required max="2147483646" min ="0"><br>
            <label for="price">금액 :</label>
            <%= request.getParameter("price")%> 원<br>
            <label for="change">거스름 돈:</label>         
    		<a id="change"></a>
        <br>
        <input type="hidden" name="settlementTool" value="cash">
         <input type=hidden name="carNum" value="<%=request.getParameter("carNum") %>">
             <input type=hidden name="beginOfTicket" value="<%=request.getParameter("beginOfTicket")%>"> 
              <input type=hidden name="endOfTicket" value="<%=request.getParameter("endOfTicket")%>"> 
            <input type=hidden name="settlementTool" value="card">
            <input type=hidden name="period" value="<%=request.getParameter("period") %>">
            <input type=hidden name="sortOfTicket" value="<%=request.getParameter("sortOfTicket") %>">
           <input type=hidden name="adaptFromNow" value="<%=request.getParameter("adaptFromNow") %>"> 
            <input type=hidden name="price" value="<%= request.getParameter("price") %>">
            <input class="star" type="submit" value="결제">
		<script>
		  var price= <%=Integer.valueOf(request.getParameter("price").toString())%>
		$(document).ready(function(){
			$("#cash").change(function(){
				$("#change").text($("#cash").val()-price);
			})
		});
		$("form").submit(function(e){
			if($("#cash").val()-price<0){
			alert("금액이 부족합니다");
			e.preventDefault(e);
			}
			})
		</script>                      
        </form>
        <a href="javascript:history.back()"><button>뒤로가기</button></a>
        <p>주의사항: 대형차량은 사무실을 통해서 예약해주시길 바랍니다. 사무실 전화번호 02-2601-8903</p>
        </div>
    </body>
</html>