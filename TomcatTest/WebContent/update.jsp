<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="javabean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <style type="text/css">
.table1{
	margin:0 auto;
	border-collapse: collapse;
	}
.table1 td{
	padding: 0px;
	height:25px;
	border:1px solid #6AB6B6;
	text-align:center;
	font-family:"微软雅黑";
	font-size:12px;
	background-color:#EAFEFE;
	}
.table1 td.title{	
	height:28px;
	color:#fff;
	background-color:#6AB6B6;
	font-weight:bold;
	font-size:20px;
	text-align: center;
	}
.table1 tr.colname{
	font-size: 14px;
	font-weight: bold;
}
* .nobd_table td{
	border: none;
}
</style>

  </head>
  
  <body>
  <div align="center" style="padding-top: 30px;" id = "add" >
   				<form action="updateUserServlet" method="post" >
   					<table class="table1" width="50%" > 
   						<tr>
   							<td colspan="2" class="title" >Patient</td>
   						</tr>
   						<tr>
   							<td>fullname</td>
   							<td> <input type="text" name="yx" id="yx" value="${Patient.fullname }" ><input type="hidden" name="id" value="${userBean.id }" >  </td>
   						</tr>
   						<tr>
   							<td>age</td>
   							<td> <input type="text" name="zy" id="zy" value="${Patient.age }" > </td>
   						</tr>
   						<tr>
   							<td>mobile</td>
   							<td> <input type="text" name="dh" id="dh"  value="${Patient.mobile }" > </td>
   						</tr>
   						<tr>
   							<td>birthdate</td>
   							<td> <input type="text" name="qq" id="qq" value="${Patient.birth_date }" > </td>
   						</tr>
   						<tr>
   							<td>sex</td>
   							<td>
   							<c:set value="male" var="sexs" ></c:set>
   							<c:if test="${Patient.sex eq sexs }">
   							<input type="radio" name="sex" value="male" checked="checked" >male<input type="radio" name="sex" value="female">female</c:if>
   							
   						
   							
   							 </td>
   						</tr>
   						<tr>
   							<td colspan="2" > <input type="submit" value="submit" >&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="reset" > &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="back" onclick="Javascript:window.history.go(-1);" > </td>
   						</tr>
   					</table>
   				</form>
   		</div>
  </body>
</html>
