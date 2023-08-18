package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookingDao;
import Model.BookService;
import Model.Customer;
import service.Confirmation;
/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String action=request.getParameter("action");
	  if(action.equalsIgnoreCase("confirm")) {
		  int bid=Integer.parseInt(request.getParameter("bid"));
		  BookingDao.updateBookingStatus(bid);
		  int cid=Integer.parseInt(request.getParameter("cid"));
		  Customer c1= BookingDao.getEmail(cid);
		  String email=c1.getEmail();
		  Confirmation cf= new Confirmation();
		  cf.sendMail(email, bid);
		  request.setAttribute("email", email);
		  request.setAttribute("bid", bid);
	      response.sendRedirect("serviceman-home.jsp");	  
	  }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if(action.equalsIgnoreCase("book"))	{
			BookService b=new BookService();
			b.setCid(Integer.parseInt(request.getParameter("cid")));
			b.setSid(Integer.parseInt(request.getParameter("sid")));
			b.setSer_id(Integer.parseInt(request.getParameter("ser_id")));
			b.setSprice(Integer.parseInt(request.getParameter("sprice")));
			b.setBooking_status("pending");
			b.setPayment_status("pending");
			BookingDao.insertBooiking(b);
			response.sendRedirect("customer-home.jsp");
		
    	}
	}

}
