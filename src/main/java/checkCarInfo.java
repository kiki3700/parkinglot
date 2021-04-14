

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Class.Database;
import Class.Ticket;
import Class.Time;
import Class.Utils;
/**
 * Servlet implementation class checkCarInfo
 */
@WebServlet("/checkCarInfo")
public class checkCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkCarInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//받은 정보 추리기
		String carNum = request.getParameter("carNum");
		int period = Integer.parseInt(request.getParameter("period"));
		String beginOfTicket=Time.addTimeFormmat(request.getParameter("beginOfTicket"));
		Boolean adaptFromNow = Boolean.parseBoolean(request.getParameter("adaptFromNow"));
		if(adaptFromNow) beginOfTicket = LocalDate.now().atStartOfDay().format(Time.formatter);		
		String endOfTicket= Time.addPeriod(beginOfTicket, period);
		
		//정보를 받은 게 없다면 db에 저장하라
		if(Database.selectQuery("car_informations", carNum).isEmpty())
			Database.newCarInfo(carNum, "small");
		
		//쿼리문 뽑기 기존 티켓의 정보를 확인한다. 하지만 잘 안됬다.
		String queryString = Database.selectQuery("car_informations", carNum);
		Map<String, String> queryMap = Utils.parseData(queryString);
		//에러의 내용은 쿠리를 아예할 수 없을 때였다. 위에 ==> 눌을 뱉는 함수로 만드는 건 어떨까?
		String oldTicketBegin= queryMap.get("begin_of_ticket");
		String oldTicketEnd = queryMap.get("end_of_ticket");
		
		
		if(!oldTicketBegin.equals("null")&&!oldTicketEnd.equals("null")) {
			if(endOfTicket.compareTo(oldTicketBegin)<0) {
				System.out.println("조건 1");
				RequestDispatcher rd = request.getRequestDispatcher("/customerPage/alreadyHaveTicket.jsp");
				request.setAttribute("oldTicketEnd", oldTicketEnd);
				rd.forward(request, response);    
				return;
			}else if(endOfTicket.compareTo(oldTicketBegin)>=0) {
				System.out.println("조건 2");				
//				endOfTicket
				Duration duration =Duration.between(Time.stringToDataTime(oldTicketBegin),Time.stringToDataTime(endOfTicket));
				int per = (int) duration.toDays();
				endOfTicket=Time.addPeriod(oldTicketEnd, per);
			}else if(oldTicketEnd.compareTo(beginOfTicket)>1) {
				System.out.println("조건 3");
				Duration duration =Duration.between(Time.stringToDataTime(beginOfTicket),Time.stringToDataTime(oldTicketEnd));
				int per = (int) duration.toDays();
				beginOfTicket=oldTicketBegin;
				endOfTicket=Time.addPeriod(oldTicketEnd, per);
			}else if(oldTicketBegin.compareTo(beginOfTicket)<1&&beginOfTicket.compareTo(oldTicketEnd)<1) {
				System.out.println("조건 4");
				Duration duration =Duration.between(Time.stringToDataTime(beginOfTicket),Time.stringToDataTime(endOfTicket));
				int per = (int) duration.toDays();
				beginOfTicket=oldTicketBegin;
				endOfTicket=Time.addPeriod(oldTicketEnd, per);
			}
		}
		
		//포워드
	   RequestDispatcher rd = request.getRequestDispatcher("/customerPage/process.jsp");
       request.setAttribute("carNum",request.getParameter("carNum"));
       request.setAttribute("beginOfTicket",beginOfTicket);
       request.setAttribute("endOfTicket", endOfTicket);
       request.setAttribute("period",request.getParameter("period"));
       request.setAttribute("sortOfTicket",request.getParameter("sortOfTicket"));
       request.setAttribute("adaptFromNow",request.getParameter("adaptFromNow"));
       request.setAttribute("price", Ticket.getTicketPrice(Integer.parseInt(request.getParameter("period"))));
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
