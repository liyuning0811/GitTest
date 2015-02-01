package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import javabean.Patient;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		userDao = new UserDao();
		String uri=request.getRequestURI();
		String string=uri.substring(uri.lastIndexOf("/")+1);
		if ("SelectAllUser".equals(string.trim())) {
			List<Patient> list=userDao.getAllUser();
			request.setAttribute("ulist", list);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else if ("selectOneUser".equals(string.trim())) {
			String ID=request.getParameter("userid");
			int id=Integer.parseInt(ID);
			Patient uBean=new Patient();
			uBean=userDao.selectOneUser(id);
			request.setAttribute("userBean", uBean);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if ("deleteOneUser".equals(string.trim())) {
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			if (userDao.deleteOneUser(id)) {
				response.sendRedirect("SelectAllUser");
			}else {
				response.sendRedirect("SelectAllUser");
			}
		}
	

	}

}
