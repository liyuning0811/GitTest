<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" /> 
<title>Patient</title>
</head>
<body>

<%String ID = (String)session.getAttribute("ID") ;  %>
Welcome,Patient.
Your ID:<%=ID %>  

<table border align="center">
<tr><th>id</th><th>fullname</th><th>age</th><th>sex</th><th>birthdate</th><th>mobile</th></tr>

<%
    String driverName="com.mysql.jdbc.Driver";
    String userName="root";
    String userPasswd="root";
    String dbName="mydb";
    
    String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn=DriverManager.getConnection(url);
    Statement st=conn.createStatement();
    ResultSet res = st.executeQuery("select * from patient where userid='"+ID+"' ");

    while(res.next()){
        out.println("<tr>");
        out.println("<td>" + res.getString("userid") + "</td>");
        out.println("<td>" + res.getString("fullname") + "</td>");
        out.println("<td>" + res.getString("age") + "</td>");
        out.println("<td>" + res.getString("sex") + "</td>");
        out.println("<td>" + res.getString("birthdate") + "</td>");
        out.println("<td>" + res.getString("mobile") + "</td>");
        out.println("</tr>");
    }
    st.close();
    conn.close();

%>
</table>
</body>
</html>