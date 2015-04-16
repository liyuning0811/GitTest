/**
 * 
 */
/**
 * @author liyuning
 *
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javabean.Patient;

public class PatientDAO{
	public List<Patient> findAll(){
		
		Connection conn=null;
		List<Patient> pList=new ArrayList<Patient>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb","root","root");
			String sql="SELECT userid,fullname,age,sex,birthdate,mobile from mydb.patient";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			ResultSet rs=pStmt.executeQuery();
			while(rs.next()){
				int userid=rs.getInt("userid");
				String fullname=rs.getString("fullname");
				int age=rs.getInt("age");
				String sex=rs.getString("sex");
				String birthdate=rs.getString("birthdate");
				String mobile=rs.getString("mobile");
				Patient patient=new Patient(userid,fullname,age,sex,birthdate,mobile);
				pList.add(patient);
			}
		}
		catch(SQLException e){
e.printStackTrace();
			return null;
	}
	catch(ClassNotFoundException e){
	e.printStackTrace();
	return null;
	}
		finally{
			if(conn!=null){
				try{
					conn.close();
				}
				catch(SQLException e){
e.printStackTrace();
					return null;
			}
			}
		}
			return pList;
	}
	
}