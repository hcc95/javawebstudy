<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'setp1.jsp' starting page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h4>step2 请输入寄送的信息</h4>
    <form action="<%= request.getContextPath() %>/ProcessStep2" method="post">
	    <table border="1" cellspacing="0" cellpadding="10" >
	    	<tr>
	    		<td colspan="2">寄送信息</td>
	    	</tr>
	    	<tr>
	    		<td>姓名</td>
	    		<td><input type="text" name="name"/> </td>
	    	</tr>
	    	<tr>
	    		<td>信用卡信息</td>
	    		<td>
	    		<input type="radio" name="cardType" value="vista"/>
	    		<input type="radio" name="cardType" value="master"/> 
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>寄送地址</td>
	    		<td><input type="text" name="address"/> </td>
	    	</tr>
	    	<tr>
	    		<td colspan="2"><input type="submit"  value="提交"/></td>
	    	</tr>
	    </table> 
    </form>
    
  </body>
</html>
