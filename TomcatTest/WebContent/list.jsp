<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="javabean.Patient" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
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
	<script type="text/javascript">
	function viewlist(){
	document.getElementById('d1').style.display='';
	document.getElementById('d2').style.display='none';
	}
	function addview(){
	document.getElementById('d1').style.display='none';
	document.getElementById('d2').style.display='';
	}
	</script>

  </head>
  
  <body onload="viewlist()"> 
   <div id="d1" align="center" style="padding-top: 30px;">
   <table width="70%"  class="table1" >
   <tr>
   <td colspan="8" class="title" >Patient  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
   </tr>
   <tr>
   						<td>UserID</td>
   						<td>Name</td>
   						<td>Age</td>
   						<td>Sex</td>
   						<td>BirthDate</td>
   						<td>Mobile</td>
   					</tr>
   					<c:forEach var="bean" items="${ulist}">
   					<tr>
   					<td>${bean.userid }</td>
   					<td>${bean.fullname }</td>
   					<td>${bean.age }</td>
   					<td>${bean.sex }</td>
   					<td>${bean.birth_date }</td>
   					<td>${bean.mobile}</td>
   					
   					<td><a href="selectOneUser?id=${bean.userid} ">Change</a>&nbsp;&nbsp;&nbsp;&nbsp;
   					<a href="deleteOneUser?id=${bean.userid} ">Delete</a>
   					</td>
   					</tr>
   					</c:forEach>
   </table>
   </div>
   <div id="d2" align="center" style="padding-top: 30px;">
   </div>
  </body>
</html>
