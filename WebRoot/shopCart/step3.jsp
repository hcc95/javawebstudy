<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"

import="com.cdut.session.Customer"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'step3.jsp' starting page</title>
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
  	<% 
  	
  	Customer customer=(Customer)session.getAttribute("customer");
  	String [] books=(String[])session.getAttribute("books"); 
  	 %>
  <body>
    <table>
    	<tr>
    		<td>顾客姓名</td>
    		<td><%= customer.getName() %></td>
    	</tr>
    	<tr>
    		<td>顾客地址</td>
    		<td><%= customer.getAddress() %></td>
    	</tr>
    	<tr>
    		<td>信用卡</td>
    		<td><%= customer.getCardType() %></td>
    	</tr>
    	<tr>
    		<td>Books</td>
    		<td>
    			<%
    				for(String book:books)
    					out.print(book+"     ");   				  
    			
    			 %>
    		</td>
    	</tr>
    </table>
  </body>
</html>
