package old;
import java.sql.*;
public class DBUtilll {
boolean bInited = false;
public void initJDBC() throws ClassNotFoundException {
Class.forName("com.mysql.jdbc.Driver");
bInited = true;
System.out.println("Success loading Mysql Driver!");

}

public Connection getConnection() throws ClassNotFoundException,
SQLException{
if(!bInited){
initJDBC();
}

Connection conn = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/PHC-DB","root","root");
return conn;
}


public boolean loginSuccess(String userName,String password){
boolean returnValue = false;
String sql = "SELECT * FROM user";
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try{
conn = getConnection();
stmt = conn.createStatement();
rs = stmt.executeQuery(sql);
while(rs.next()){
String userNameInDB = rs.getString("userid");
String passwordInDB = rs.getString("password");
if(userNameInDB.equals(userName) &&
passwordInDB.equals(password)){
returnValue = true;
break;
}
}
}catch (ClassNotFoundException e) {
e.printStackTrace();
}catch (SQLException e) {
e.printStackTrace();
}

return returnValue;

}
}
