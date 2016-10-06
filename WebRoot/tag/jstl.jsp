<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstl.jsp' starting page</title>
    <meta charset="utf-8">
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
   <%--  This is my JSP page. <br>
    <h4>c:out  一个强大输出工具 可以输出特殊字符的值</h4>
    <% request.setAttribute("book", "<<book>>"); %>
    
    book:${requestScope.book}
    <br>
    book:<c:out value="${requestScope.book}" default="13"></c:out> --%>
 	
 	
 	
 	
 	 <c:set var="name" value="hcc" scope="page"></c:set>
  	<%-- <%
  		相当于：pageContext.setAttribute("name", "hcc")
  		
  		
  		 c:set 为域赋值       其中val支持el表达式 
  		 还可以为域对象的javabean赋值
  		 target value 都支持el表达式
  	
  	 %> --%>
    name: ${pageScope.name}
  	<c:remove var="name" scope="page"/>
 	
 	<!--  
 	
 		c:remove移除属性 
 	
 	-->
 	
 	
  	<br>
  	<br>
  	name: ${pageScope.name}
  <br>
  <br>
   <c:set var="subject" value="{$param.subject}" scope="session"></c:set>
   subject:${sessionScope.subject}
   
   <br>
   <br>
   
   <c:set var="age" value="20" scope="page"></c:set>
   age: ${pageScope.age}
  <%--  <c:if  test="${requestScope.age}>18">成年了</c:if> --%>
   <c:choose>
   		<c:when>
   		</c:when>
   </c:choose>
  </body>
</html>
