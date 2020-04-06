package com.fatima;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/home")
public class MyServlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 
		 PrintWriter out= res.getWriter();
		 out.print("hi"+" ");
		 
			/*
			 * ServletContext cnxt = getServletContext(); String str=
			 * cnxt.getInitParameter("name");
			 */
		
		 out.println( getServletConfig().getInitParameter("name"));
		 
	 }
}
