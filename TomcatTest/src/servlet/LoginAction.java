package servlet;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		String userid=request.getParameter("userid");
        String password=request.getParameter("password");
        
        if ("".equals(userid)||"".equals(password)) {
			response.sendRedirect("index.jsp");
		}
        else {
   
       	 String sql="select * from user where userid='"+userid+"'and password='"+password+"'";
			Statement statement;
			ResultSet resultSet;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/PHC-DB", "root", "root");
					statement=connection.createStatement();
					DatabaseMetaData dbmd=connection.getMetaData();
					
					System.out.println(dbmd.getURL());
					resultSet=statement.executeQuery(sql);
					boolean isvalid = false;
					if (resultSet.next()) {
						isvalid=true;
					}
					if(isvalid){
						response.sendRedirect("SelectAllUser");
					}
					else {
						response.sendRedirect("index.jsp");
					}
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
	

	}

}
