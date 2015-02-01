<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
   				<form action="login" method="post" >
   					<table class="table1" width="50%" >
   						<tr>
   						<td class="title" colspan="2"  >医療可視化システム</td>
   						</tr> 
   						<tr>
   							<td>ID</td>
   							<td> <input type="text" name="ID" > </td>
   						</tr>
   						<tr>
   							<td>password</td>
   							<td> <input type="password" name="password" > </td>
   						</tr>
   						<tr>
   							<td colspan="2"  > <input type="submit" value="login"  > <input type="reset" value="reset"  ></td>
   						</tr>
   					</table>
   					</form>
   					</div>
  </body>
</html>
