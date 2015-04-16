  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table border="1">  
        <tr>  
            <td>id</td>  
            <td>Name</td>  
            <td>Sex</td>  
            <td>Age</td>  
            <td>Birth</td>
            <td>Phone</td>   
            
        </tr>  
          
        <c:forEach items="${patientList}" var="patient">  
            <tr>  
                <td>${patient.userid }</td>  
                <td>${patient.fullname }</td>  
                <td>${patient.sex }</td>  
                <td>${patient.age }</td>  
                <td>${patient.birthdate }</td>  
                <td>${patient.mobile }</td>  
            </tr>  
        </c:forEach>  
    </table>  
</body>
</html>