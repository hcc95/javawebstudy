<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" import="com.cdut.session.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//模拟servlet操作
	List<Customer> customers=new ArrayList<Customer>();
	customers.add(new Customer("hcc","dz","nh"));
	customers.add(new Customer("hcc1","dz","nh"));
	customers.add(new Customer("hcc2","dz","nh"));
	customers.add(new Customer("hcc3","dz","nh"));
	
	request.setAttribute("customers", customers);
	
%>
	<!-- 在页面上对其遍历 -->
<jsp:forward page="test.jsp"></jsp:forward>

</body>
</html>