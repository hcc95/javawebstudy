<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userBean.jsp' starting page</title>
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
    This is my JSP page. <br>
    <%-- <jsp:useBean id="customer" class="com.cdut.session.Customer" scope="session"></jsp:useBean>
    <%
    /*
    1 从scope中获取id属性值，赋给class
    2 若属性为空  则利用反射创建一个新的对象 把该对象赋给id 并以id为属性放到scope中
    
    
    */
    
    customer.setName("123");
    out.print(customer.getName());
    
     %> --%>
     
     <jsp:useBean id="customer" class="com.cdut.session.Customer" scope="request">
     </jsp:useBean>
    <%--  <jsp:setProperty  property="name" value="hcc" name="customer"/> --%>
   <!-- /userBean.jsp?name=123&address=ert 
   
   		参数必须对应
   -->
    <jsp:setProperty property="*" name="customer"/>
     name:<jsp:getProperty property="name" name="customer"/>
     address:<jsp:getProperty property="address" name="customer"/>
  </body>
</html>
