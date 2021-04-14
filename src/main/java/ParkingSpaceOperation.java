

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Class.ParkingSpace;
/**
 * Servlet implementation class ParkingSpaceOperation
 */
@WebServlet("/ParkingSpaceOperation")
public class ParkingSpaceOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingSpaceOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String size = request.getParameter("size").toString();
		String operator = request.getParameter("operator");
		if(size.equals("big")) {
			if(operator.equals("plus")) {
			ParkingSpace.big.setAvailableSpace(1);
			}else {
			ParkingSpace.big.setAvailableSpace(-1);
			}
		}else {
			if(operator.equals("plus")) {
			ParkingSpace.small.setAvailableSpace(1);
			}else {
			ParkingSpace.small.setAvailableSpace(-1);
			}
		}
		response.sendRedirect("/Parkinglot/admin/admin.jsp");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
