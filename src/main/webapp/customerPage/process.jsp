<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Class.Ticket"%>
    <!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script
                src="https://code.jquery.com/jquery-3.6.0.js"
                 integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
                crossorigin="anonymous"></script>
        <title>결제 페이지</title>
        <link rel="stylesheet" href="/Parkinglot/resources/css/style.css">
    </head>
    <body>

        <div id="box">
            <h2>결제</h2>
            

            <form id="settle" action="/Parkinglot/TicketSettlement" >
            <% String period = request.getAttribute("period").toString(); %>
          	 <label for="price">선택 상품 </label>
          	 <%= Ticket.getTicketName(Integer.parseInt(period)) %><br>
       		  <label for="price">가격</label>
           <%= Ticket.getTicketPrice(Integer.parseInt(period))%>원<br>
            <label for="settlementTool">결제방법</label>
            <select class="settlementTool" name="settlementTool">
                <option value="card">카드</option>
                <option value="cash">현금</option>
            </select><br>
            <script>
            $(document).ready(function(){
            	$(".settlementTool").change(function() {
            		console.log($(".settlementTool option:selected").val());
            		
    				if($(".settlementTool option:selected").val()=="cash"){
    					$("#settle").attr("action","/Parkinglot/customerPage/processWithCash.jsp");
    					console.log($(".settlementTool option:selected").val());
    				}
    				if($(".settlementTool option:selected").val()=="card"){
    					$("#settle").attr("action","/Parkinglot/TicketSettlement");
    					console.log($(".settlementTool option:selected").val());
    				}
            	})
            });

            </script>
               <input type=hidden name="carNum" value="<%=request.getAttribute("carNum") %>">
             <input type=hidden name="beginOfTicket" value="<%=request.getAttribute("beginOfTicket")%>"> 
            <input type=hidden name="settlementTool" value="card">
            <input type=hidden name="period" value="<%=request.getAttribute("period") %>">
            <input type=hidden name="sortOfTicket" value="<%=request.getAttribute("sortOfTicket") %>">
           <input type=hidden name="adaptFromNow" value="<%=request.getAttribute("adaptFromNow") %>"> 
            <input type=hidden name="price" value="<%=Ticket.getTicketPrice(Integer.parseInt(period))%>">
           <input type=hidden name="cash" value ="0"> 
         
            
            
            <input type="submit" value="결제"><br>
            </form>
            <a href="javascript:history.back()"><button>뒤로가기</button></a>
        </div>
            
    </body>
</html>