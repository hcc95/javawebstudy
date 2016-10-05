<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"

	session="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    
    <% 	
    	HttpSession session=request.getSession(true);
     
    	out.print(session.getId());
    	out.print("<br>");
    	out.print(session.getMaxInactiveInterval());
    	session.setMaxInactiveInterval(1);
    	out.print(session.getMaxInactiveInterval());
    %>
    
    <%  
    	/*
    	1 session的创建
	    	jsp ：如果客户端第一次访问会创建session ，
	    	如果不是第一次 就不会创建 会从其他页面传一个session过来
	    	如果page指令是false 就不会创建session了
	    	
	    	
	    	session=“false”
	    	当前页面禁用session隐藏变量  但是可以创建httpSession对象
	    	
	    	servlet：
	    	对于servlet而言  也可以接受其他页面传过来的session
	    	若servlet是浏览器第一个访问的浏览器资源 
	    	则只有调用了request.getSession()和request.getSession(true)
	    	才会创建session
	    	
	    	>request.getSeesion(boolean Create)
	    	
	    	create 为false ，若没有和jsp页面关联的httpSession对象，则返回null，有则返回true
	    	create为true ，一定返回一个httpSession对象，若没有关联的，会直接创建一个session返回
	    	若有 直接返回关联的
    	
    		request.getSeesion()等同于request.getSeesion(true)
    	2 session的销毁
	    	1）session.invalidate();该方法是session失效
	    	2）服务器卸载web应用
	    	3）超过session的过期时间
    	*/
    
    
    	/* Cookie cookie=new Cookie("JSESSSION",session.getId());
    	//持久化sessioncookie
    	cookie.setMaxAge(20);
    	response.addCookie(cookie); */
     %>
  </body>
</html>
