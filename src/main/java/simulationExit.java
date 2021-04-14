

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.exceptions.CJException;

import Class.Database;
import Class.Payment;
import Class.Time;
import Class.Utils;

/**
 * Servlet implementation class simulationExit
 */
@WebServlet("/simulationExit")
public class simulationExit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public simulationExit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//변수 할당
		String carNum=request.getParameter("carNum");
		String date =request.getParameter("date");
		String time =request.getParameter("time");
		String exitTime =LocalDateTime.now().format(Time.formatter);
		if(!date.isEmpty()&&!time.isEmpty()) {
		exitTime= Time.formDateTime(date,time);
		}
		
		try {
				String queryString = Database.selectLastQuery("enter_logs",carNum);
				Map<String, String> queryMap = Utils.parseData(queryString);
				String enterTime = Database.selectEnterTime(carNum);
				if(enterTime.compareTo(exitTime)>0||!queryMap.get("exit_time").equals("null")) {
					CJException a = new CJException();
					throw a;
				}
				int price = Payment.calculatePrice(carNum, exitTime);
//				if(queryMap.get("enter_time").isEmpty()||!queryMap.get("exit_time").equals("null")) {
//					response.sendRedirect("/Parkinglot/settelerPage/settlementFail.jsp");
//				}
				RequestDispatcher rd = request.getRequestDispatcher("/settlerPage/settler.jsp");
				request.setAttribute("carNum", carNum);
				request.setAttribute("price", price);
				request.setAttribute("exitTime", exitTime);
				request.setAttribute("enterTime", enterTime);
				rd.forward(request, response);
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/Parkinglot/settlerPage/ExitFail.jsp");
			
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
