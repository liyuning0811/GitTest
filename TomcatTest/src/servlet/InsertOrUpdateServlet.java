package servlet;

import java.io.IOException;

import javabean.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.UserServlet;
import dao.UserDao;

/**
 * Servlet implementation class InsertOrUpdateServlet
 */
@WebServlet("/InsertOrUpdateServlet")
public class InsertOrUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UserDao userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrUpdateServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        userDao=new UserDao();
        String uri=request.getRequestURI(); 
        String string=uri.substring(uri.lastIndexOf("/")+1);
        String fullname=request.getParameter("fullname");
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");
        String  mobile=request.getParameter("mobile");
        String  birth_date=request.getParameter("birth_date");
        Patient patient=new Patient();
        patient.setFullname(fullname);
        if (!"".equals(age)&&age!=null) {
        	patient.setAge(Integer.parseInt(age));
		}else {
			patient.setAge(0);
		}
        patient.setSex(sex);
        patient.setMobile(mobile);
        patient.setBirth_date(birth_date);
        
       if("insertUserServlet".equals(string.trim())){
    	   if (userDao.insertUser(patient)) {
    		   response.sendRedirect("SelectAllUser");
		}else {
			response.sendRedirect("SelectAllUser");
		}
    	  
    	 }else if ("updateUserServlet".equals(string.trim())) {
			String stid=request.getParameter("id");
			if(!"".equals(stid)&&stid!=null){
				patient.setUserid(Integer.parseInt(stid));
			}else {
				patient.setUserid(-1);
			}
			if(userDao.updateOneUser(patient)){
				response.sendRedirect("SelectAllUser");
			}else {
				response.sendRedirect("SelectAllUser");
			}
		}
		
	

	}

}
