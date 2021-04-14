

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class.Payment;
import Class.Time;
/**
 * Servlet implementation class TickettSettle
 */
@WebServlet("/TicketSettlement")
public class TicketSettlement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketSettlement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		int result =-1;
		//변수할당
		String settlementTool = request.getParameter("settlementTool");
		String carNum = request.getParameter("carNum");
		int period = Integer.parseInt(request.getParameter("period"));
		int price = Integer.parseInt(request.getParameter("price"));
		int cash = Integer.parseInt(request.getParameter("cash"));
//		if(settlementTool.equals("cash")) {
//			System.out.println("cash");
//			long cash = Long.parseLong(request.getParameter("cash"));
//		}
		String sortOfTicket = request.getParameter("sortOfTicket").toString();
		
		String beginOfTicket = request.getParameter("beginOfTicket").toString();
		//1트루면 시간을 오늘 시간으로 바꾼다

		String endOfTicket =request.getParameter("endOfTicket").toString();
	
		//할것
			if(settlementTool.equals("card")) {
			result = Payment.settleTicket(carNum, price, sortOfTicket, beginOfTicket, endOfTicket);
			}
			else {
				result = Payment.settleTicket(carNum, price, sortOfTicket, beginOfTicket, endOfTicket, cash);
			}
			
			
			if(result==1) {
				  RequestDispatcher rd = request.getRequestDispatcher("/customerPage/processComplete.jsp");
				request.setAttribute("beginOfTicket", beginOfTicket);
				request.setAttribute("endOfTicket", endOfTicket);
				request.setAttribute("settlementTool", settlementTool);
				request.setAttribute("carNum", carNum);
				request.setAttribute("price", price);
				rd.forward(request, response);
			}else if(result==-1) {
				response.sendRedirect("/Parkinglot/customerPage/processFail.jsp");
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
