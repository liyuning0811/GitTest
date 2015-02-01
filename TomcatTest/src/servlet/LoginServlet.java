package servlet;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import old.DBUtilll;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String userName = request.getParameter("ID");
		String password = request.getParameter("password");
		/*
		DBUtil db = new DBUtil();
		boolean canLogin = db.loginSuccess(userName, password);
		if(canLogin){
		response.sendRedirect("Patient.jsp");
		}else{
		response.sendRedirect("failed.jsp");
		}
		*/
		 try {  
	            Class.forName("com.mysql.jdbc.Driver");  
	        } catch (Exception e) {  
	            System.out.print("Class Not Found Exception");  
	        }
		 String url = "jdbc:mysql://localhost:3306/mydb";  
	        Connection conn = null; 
	        Connection conn2 = null; 
	        Connection conn3 = null; 
	        Statement stmt = null; 
	        Statement stmt2 = null; 
	        Statement stmt3 = null; 
	        ResultSet rs = null;  
	        ResultSet rs2=null;
	        ResultSet rs3=null;
	        try {  
	            conn = (Connection) DriverManager.getConnection(url,"root","root"); 
	            conn2 = (Connection) DriverManager.getConnection(url,"root","root"); 
	            conn3= (Connection) DriverManager.getConnection(url,"root","root"); 
	            stmt = (Statement) conn.createStatement();  
	            stmt2 = (Statement) conn2.createStatement(); 
	            stmt3 = (Statement) conn3.createStatement(); 
	            String sql = "select * from new_table where ID='"+userName+"' and password= '"+password+"'";  
	            String sql2="select * from new_table where ID='"+userName+"' and familypsw= '"+password+"'"; 
	            String sql3="select * from DoctorID where ID='"+userName+"' and password= '"+password+"'"; 
	            rs = stmt.executeQuery(sql);  
	            rs2=stmt2.executeQuery(sql2);
	            rs3=stmt3.executeQuery(sql3);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        HttpSession session = request.getSession();  
	        session.setAttribute("ID", userName);  
	        try {  
	            if(rs.next()){  
	            	 session.setAttribute("ID",rs.getString("ID")) ; 
	                response.sendRedirect("Patient.jsp") ;  
	                return;  
	            }
	            
	            else if(rs2.next()){
	            	session.setAttribute("ID",rs2.getString("ID")) ; 
	            	response.sendRedirect("Family.jsp") ;
	            	return;
	            }
	            else if(rs3.next()){
	            	session.setAttribute("ID",rs3.getString("ID")) ; 
	            	response.sendRedirect("Doctor.jsp") ;
	            	return;
	            }
	            
	            
	            else
	            {  
	                response.sendRedirect("fail.jsp") ;  
	                return;  
	            }  
	        }
	        catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}

}
