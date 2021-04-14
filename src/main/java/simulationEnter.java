

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.core.IsNull;

import Class.InAndOut;
import Class.Time;

/**
 * Servlet implementation class simulationEnter
 */
@WebServlet("/simulationEnter")
public class simulationEnter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public simulationEnter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String carNum=request.getParameter("carNum");
		String date =request.getParameter("date");
		String time =request.getParameter("time");
		String carSize = request.getParameter("carSize");
		String dateTime =LocalDateTime.now().format(Time.formatter);
		if(!date.isEmpty()&&!time.isEmpty()) {
		dateTime = Time.formDateTime(date,time);
		}

		int result=InAndOut.enter(carNum, carSize, dateTime);
		String resultString = "fail"; 
		RequestDispatcher rd = request.getRequestDispatcher("/simulator.jsp");
		if(result==1) {
			resultString = "sucess!";
		}
		
		request.setAttribute("result", resultString);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
