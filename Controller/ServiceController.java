package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ServicemanServiceDao;
import Model.ServicemanServicess;

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/ServiceController")
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("edit")) {

			int id = Integer.parseInt(request.getParameter("sid"));
			System.out.println(id);
			ServicemanServicess s = ServicemanServiceDao.getServiceById(id);
			request.setAttribute("data", s);
			request.getRequestDispatcher("serviceman-single-service.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("upload")) {
			ServicemanServicess s = new ServicemanServicess();
			s.setServiceman_id(Integer.parseInt(request.getParameter("s_id")));
			s.setService_name(request.getParameter("s_name"));
			s.setSprice(Integer.parseInt(request.getParameter("s_price")));
			s.setService_duration(request.getParameter("s_duration"));
			s.setService_category(request.getParameter("s_category"));
			ServicemanServiceDao.insertService(s);
			System.out.println("data inserted");
			response.sendRedirect("serviceman-home.jsp");
		} else if (action.equalsIgnoreCase("update")) {
			ServicemanServicess s = new ServicemanServicess();
			s.setSid(Integer.parseInt(request.getParameter("sid")));
			s.setService_name(request.getParameter("sname"));
			s.setSprice(Integer.parseInt(request.getParameter("sprice")));
			s.setService_duration(request.getParameter("sduration"));
			s.setService_category(request.getParameter("scategory"));
			ServicemanServiceDao.updateService(s);
			response.sendRedirect("Serviceman-manage-service.jsp");
            
		}

	}

}
