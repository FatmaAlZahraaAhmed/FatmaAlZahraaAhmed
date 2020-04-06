package com.fatima;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServerlt extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int k = i + j;
		// the output should e in the web not the console
		/* we use print writer class 
		 * PrintWriter out = res.getWriter();
		 * out.println("the result is " + k); */ 
//--------------------------------------------------------------------------
		/*
		 * //To call a servlet from a servlet(RequestDispatcher-- or Send Direct )
		 *  1-get the instance of the request dispatcher class &
		 *   mention the url of the servlet
		 * setting data inside reqest object req.setAttribute("Kvalue", k);
		 * // then fetch it in sqr srvlet
		 * RequestDispatcher rd = req.getRequestDispatcher("sqr"); 
		 * // send the request and the respons objects 
		 * rd.forward(req, res);// dont forget the server mapping at xml file 
		 *  // then this class shoud be able to pss the valus to the reqested servlet
		 */
//----------------------------------------------------------------------------
/* 2-use send direct 
//Sending data from one servlet to another
		{1-URL RW,
		2-session,
		3-cookie}*/
/*
 *  sending a clint respons informing he's been redirected
 * also modify the url to send the data in it
 * again becuse we are using Getmethod
 *  {1}URL ReWritting sqr?variable=data
 *  res.sendRedirect("sqr?=k"+k); */
//----------------------------------------------------------------------------
		/*
		 * {2}session
		 * HttpSession session =req.getSession();
		 * //get the hold on the whole session
		 * session.setAttribute("k", k);//fetche it at sqr class
		 */
//----------------------------------------------------------------------------
		Cookie cookie = new Cookie("k",k+"");//append int with ""=string
		res.addCookie(cookie);
//this'll send responce to clint then he'll request agian sqr servlet
//that mean he'll send the cookie as well
		res.sendRedirect("sqr");
		
		

	}

}
