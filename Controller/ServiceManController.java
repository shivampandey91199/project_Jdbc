package Controller;

import java.beans.beancontext.BeanContextServicesSupport;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ServiceManDao;
import Model.ServiceMan;
import service.Servicess;

/**
 * Servlet implementation class ServiceManController
 */
@WebServlet("/ServiceManController")
public class ServiceManController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			ServiceMan s = new ServiceMan();
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			ServiceManDao.insertData(s);
			request.setAttribute("msg", "Data inserted successfully");
			request.getRequestDispatcher("serviceman-login.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("login")) {
			ServiceMan s = new ServiceMan();
			String email = request.getParameter("email");
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			boolean flag = ServiceManDao.checkEmail(email);
			if (flag == true) {
				ServiceMan s1 = ServiceManDao.servicemanLogin(s);
				if (s1 == null) {
					request.setAttribute("msg3", "Password incorrect");
					request.getRequestDispatcher("serviceman-login.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("serviceman-home.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("msg2", "Account Not Register");
				request.getRequestDispatcher("serviceman-login.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("update")) {
			ServiceMan s = new ServiceMan();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			ServiceManDao.updateData(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("serviceman-home.jsp").forward(request, response);

		} else if (action.equalsIgnoreCase("change password")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = ServiceManDao.checkOldPassword(email, op);
			if (flag == true) {
				if (np.equals(cnp)) {
					ServiceManDao.updatePassword(email, np);
					response.sendRedirect("serviceman-home.jsp");
				}
			} else {
				request.setAttribute("msg", "Old password is incorrect");
				request.getRequestDispatcher("serviceman-change-password.jsp");
			}
		} else if (action.equalsIgnoreCase("Get OTP")) {
			String email = request.getParameter("email");
			Servicess s = new Servicess();
			Random r = new Random();
			int num = r.nextInt(9999);
			System.out.println(num);
			s.sendMail(email, num);
			request.setAttribute("email", email);
			request.setAttribute("otp", num);
			request.getRequestDispatcher("serviceman-verify-otp.jsp");
	        }
		 else if(action.equalsIgnoreCase("verify")) {
			String email=request.getParameter("email");
			int otp1=Integer.parseInt(request.getParameter("otp1"));
			int otp2=Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("serviceman-new-password.jsp").forward(request, response);
			}
					
		}
	}

}
