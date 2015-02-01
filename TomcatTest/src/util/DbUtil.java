package util;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DbUtil {
	 private static Connection connection;
	  private Statement statement;
	  private ResultSet resultSet;
	  private PreparedStatement preparedStatement;
	  static{
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		  catch (SQLException e) {	
				e.printStackTrace();
			}
	  }
	  
	  public ResultSet excuteSql(String sql) {
		  try {
			statement=(Statement)connection.createStatement();
			resultSet=statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		return resultSet ;
	  }
	  public ResultSet excuteSql(String sql,Object[] obj){
			 int len=obj.length;
			 try {
				preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				preparSql(obj, len);
				resultSet=preparedStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 return resultSet;
		 }
	  public void preparSql(Object[] obj,int length)throws SQLException{
			 for(int i=0;i<length;i++){
				 if(obj[i].getClass()==String.class){
					 preparedStatement.setString(i+1, obj[i].toString());
				 }
				 else if (obj[i].getClass()==Integer.class) {
					preparedStatement.setInt(i+1, (Integer)obj[i]);
				}
				 else if(obj[i].getClass()==Double.class){
				preparedStatement.setDouble(i+1, (Double)obj[i]);
				}//java.sql.Date
				else if (obj[i].getClass()==Date.class) {
					preparedStatement.setDate(i+1,(Date)obj[i]);
				}
			 }
			                    
		 }
	  public void close() {
		  try {
		  	if (resultSet!=null) {
		  		resultSet.close();
		  	}
		  } catch (SQLException e) {
		  	e.printStackTrace();
		  }
		  	
		  try {
		  	if (statement!=null) {
		  		statement.close();
		  	}
		  } catch (SQLException e) {
		  	e.printStackTrace();
		  }
		  try {
		  	if (preparedStatement!=null) {
		  		preparedStatement.close();
		  	}
		  } catch (SQLException e) {
		  	e.printStackTrace();
		  }
		  }

	  public int excute(String sql,Object[] obj) {
			int row=0;
			int len=obj.length;
			try {
				preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
				preparSql(obj, len);
				row=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close();
			}
			return row;
		}
	  
	  public int excute(String sql) {
			int row=0;
			try {
				statement=(Statement) connection.createStatement();
				row=statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}
			return row;
		}


}