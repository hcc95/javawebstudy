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
    <h4>step1 选择购买的图书</h4>
    <form action="<%= request.getContextPath() %>/ProcessStep1" method="post">
    	<table border="1" cellpadding="10" cellspacing="0">
    		<tr>
    			<td>书名</td>
    			<td>购买</td>
    		</tr>
    		<tr>
    			<td>java</td>
    			<td><input type="checkbox" name="book" value="java"/></td>
    		</tr>
    		<tr>
    			<td>oracle</td>
    			<td><input type="checkbox" name="book" value="oracle"/></td>
    		</tr>
    		<tr>
    			<td>php</td>
    			<td><input type="checkbox" name="book" value="php"/></td>
    		</tr>
    		<tr>
    			<td>c++</td>
    			<td><input type="checkbox" name="book" value="c++"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">
    			<input type="submit" value="提交" />
    			</td>
    		</tr>
    	</table>
    	
    </form>
  </body>
</html>
