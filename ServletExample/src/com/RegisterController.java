package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/abcd") // This annotation performs the functions of web.xml
public class RegisterController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Connected.......");
	}

	/**
	 * This method shows how to send variables while redirecting to a page using response.sendRedisrect
	 * 
	 * response.sendRedirect works on the client side 
	 * 
	 * the new redirected URL is seen in the address bar
	 * 
	 * response.sendRedirect can even redirect to a page outside the server as shown https://www.google.com/
	 * 
	 * In case of sendRedirect() call, the old request and response object is lost because it is treated as a 
	 * new request by the browser. And that further makes it slow
	 * 
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		System.out.println("Connected........."+name+"  "+pwd+"  "+age+"  "+gender);
		
	
		//sendRedirect creates a new request
		if(name.equals("ankita")&&pwd.equals("12345"))
			response.sendRedirect("success.jsp?uname="+name+"&age="+age+"&gender="+gender);
		else
			response.sendRedirect("https://www.google.com/");
	}*/
	
	
	/**
	 * This method shows the use of RequestDispatcher which is faster than sendRedirect
	 * It performs server side forward/include
	 * the new URL is NOT seen in the address bar
	 * Its works within the server
	 * developers pass the request and response object so that the old request object...
	 * ...is present in the new resource which is going to process the request
	 * It is faster than send.Redirect
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		response.setContentType("text/html"); // MIME
//        PrintWriter pw=response.getWriter();
//        pw.write("<h1>Welcome to servlet  <h1>");
		
		RequestDispatcher dis= request.getRequestDispatcher("/success.jsp");
		
		//this includes the response content also and hence "prints welcome to servlet"
	    //dis.include(request, response); 
	         
	    // this only forwards request another resource and does NOT print "welcome to servlet" 
	    dis.forward(request, response); 

	}

}
