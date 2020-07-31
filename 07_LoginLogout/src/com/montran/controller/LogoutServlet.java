package com.montran.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String a, b, c;
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
				
		//session.getMaxInactiveInterval();
		session.removeAttribute("LoginId");
		
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		out.println("<h4><font color = red>Logout Successful..</font></h4>");
		rd.include(request, response);
	}
}
