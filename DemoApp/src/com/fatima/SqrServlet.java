package com.fatima;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sqr")
public class SqrServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

// 1)fetching the data and cast it becuse it object of an object 
		// int k=(int)req.getAttribute("Kvalue");
// the value here is the addition of the 2numbers
//2)fetching the data from the clint
		// int k = Integer.parseInt(req.getParameter("k"));
// to work as needed the url shoud be formated to suit this situation
//becuse we'r using get method
//3)fetching data from session
		/*
		 * HttpSession session = req.getSession(); //it will return aobject so cast it
		 * int k = (int)session.getAttribute("k");
		 */
//4)cookies
		int k = 0;
		//array of cookies cuse the server sending all the cookies don't know which
		Cookie cookies[] = req.getCookies();
		
		for(Cookie c: cookies) {
			
			if(c.getName().equals("k")) {
				k=Integer.parseInt(c.getValue()	);
			}
		}
		
		k = k * k;
		PrintWriter out = res.getWriter();
		out.println("sqr called"+"\n"+"Result is " + k);

	}

}
