package com.cdut.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessStep1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProcessStep1() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 获取选中的图书信息
		String[] books=request.getParameterValues("book");
		//2将图书信息放到session中
		request.getSession().setAttribute("books", books);
		
		/*
		 * 相对路径可能会有问题 但是绝对路径一定没有问题
		 * 
		 * 在servlet到jsp页面时，此时地址栏上显示的是servlet的路径，
		 * 此时的jsp的超链接是相对jsp页面的相对路径 则可能会出现路径混乱的问题
		 */
		//3 重定向到shopCart/的step2.jsp
		//System.out.println(request.getContextPath()+"/shopCart/step2.jsp");
		response.sendRedirect(request.getContextPath()+"/shopCart/step2.jsp");
		/*
		 * 请求转发
		 * request.getRequestDispatcher(request.getContextPath()+"/shopCart/step2.jsp")
		.forward(request, response);
		*/
		/*
		 * sendRedirect 地址栏会显示重新转到的jsp地址
		 * RequestDispatcher 地址栏不会发生变化
		 */
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
