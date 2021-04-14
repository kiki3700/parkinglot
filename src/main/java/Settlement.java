

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Coupon;
import Class.InAndOut;
import Class.Payment;
//import jdk.jfr.internal.RequestEngine;

/**
 * Servlet implementation class Settlement
 */
@WebServlet("/Settlement")
public class Settlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Settlement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub;
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//변수 할당
		String settlementTool = request.getParameter("settlementTool");
		String carNum = request.getParameter("carNum");
		int price = Integer.parseInt(request.getParameter("price"));
		int cash = Integer.parseInt(request.getParameter("cash"));
		//result는 결과의 분기로 사용된다.
		int result = 0; 
		
		
		//쿠폰 사용 로직
		Coupon coupon=null;
		switch(request.getParameter("coupon")) {
		case "absolute" : coupon=Payment.absolute;
		break;
		case "relative" : coupon=Payment.relative;
		}
		System.out.println(coupon);
		
		//최종 계산 로직
		if(settlementTool.equals("card")) {
			result = Payment.settlement(carNum, price, coupon);
		}else {
			result = Payment.settlement(carNum, price, coupon, cash);
		}
		System.out.println(result);
		int discount = Payment.calculateDiscountAmount(price, coupon);
		int finalPrice = Payment.calculateFinalPrice(price, discount);
		

		
		// 분화한다면  result의 결과값을 settlement 메서드를 이용해서 나눠야된다.
		//ex)잔돈부족 -2, 기계고장 -1 ⇒ 현금결제로 넘어가기 넘어간다면 다시 포워딩 하는 것 준비하기
		if(result ==1 ) {	
			InAndOut.exit(carNum);
			RequestDispatcher rd = request.getRequestDispatcher("/settlerPage/settlementComplete.jsp");
			request.setAttribute("carNum", carNum);
			request.setAttribute("price", price);
			request.setAttribute("finalPrice", finalPrice);
			request.setAttribute("settlementTool", settlementTool);
			rd.forward(request, response);
		}else {
			response.sendRedirect("/Parkinglot/settlerPage/settlementFail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
