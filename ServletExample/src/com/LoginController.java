package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pass");
		if (username.equals("candid") && pwd.equals("12345")) {
			HttpSession ses = request.getSession();
			ses.setAttribute("user", username);

			/**
			 * Run the program in browser and check for the cookie named auth
			 */
			Cookie ck = new Cookie("auth", username);
			ck.setMaxAge(600);

			response.addCookie(ck);
			response.sendRedirect("home.jsp");
		} else {
			//URL Rewriting
			response.sendRedirect("login.jsp?status=invaild username or password");
		}
	}
}
