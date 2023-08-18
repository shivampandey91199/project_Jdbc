package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CustomerDao;
import Model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			Customer s = new Customer();
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			CustomerDao.insertData(s);
			request.setAttribute("msg", "data inserted successfully");
			request.getRequestDispatcher("customer-login.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("login")) {
			Customer s = new Customer();
			String email  = request.getParameter("email");
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			
			boolean flag = CustomerDao.checkEmail(email);
			if(flag == true) {
				Customer s1 = CustomerDao.customerLogin(s);
				if(s1 == null) {
					request.setAttribute("msg3", "password is incorrect");
					request.getRequestDispatcher("customer-login.jsp").forward(request, response);
				}
				else {
					HttpSession session  =request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("customer-home.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg2", "accout not registered");
				request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			}
		}
	}

}
