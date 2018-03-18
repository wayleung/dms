package com.lyb.dms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		  HttpServletRequest req = (HttpServletRequest)request;
	        HttpServletResponse resp =(HttpServletResponse) response;
	        HttpSession session = req.getSession();
	        String uri = req.getRequestURI();//得到请求地址
	        if(uri.contains("login")||uri.contains("nav")||uri.contains("head")||uri.contains("footer")){
	        	chain.doFilter(req, resp);
	        }else{
	        	if(session.getAttribute("studentId")==null&&session.getAttribute("adminId")==null){
		        	resp.sendRedirect("../login.html");
		        }else{
		        	chain.doFilter(req, resp);
		        }
	        }
	        
	        
	        
	       
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
