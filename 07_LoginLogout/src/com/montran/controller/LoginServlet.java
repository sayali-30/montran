package com.montran.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String loginId, password, a, b, c; 
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		loginId =  request.getParameter("txtLoginId");
		password =  request.getParameter("txtPassword");
		
		if(session.getAttribute("LoginId")!=null && session.getAttribute("Password")!=null && 
				loginId.equals(session.getAttribute("LoginId").toString()) && password.equals(session.getAttribute("Password").toString()))
		{
			//session.setAttribute("LoginId", loginId);
				//session.setAttribute("Password", password);
				
				session.setMaxInactiveInterval(600);
				response.sendRedirect("userHome.jsp");
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			out.println("<h4><font color = red>Invalid Username or Pasword !!</font></h4>");
			rd.include(request, response);
		}
	} 
}
