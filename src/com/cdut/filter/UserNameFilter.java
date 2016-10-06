package com.cdut.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class UserNameFilter
 */
public class UserNameFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String initUser=filterConfig.getInitParameter("userName");
		System.out.println(initUser);
		String username=request.getParameter("username");
		System.out.println(username);
		/*if(!initUser.equals(username)){
			request.setAttribute("message", "用户名不正确");
			request.getRequestDispatcher("/filter/login.jsp").forward(request, response);;
		}*/
		chain.doFilter(request, response);
	}

	private FilterConfig filterConfig;
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig=fConfig;
	}

}
