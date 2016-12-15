package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;
import com.daoServices.DaoService;
import com.providers.DaoServiceProvider;

/**
 * Servlet implementation class SignupServlet
 */

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User newUser = (User) request.getAttribute("new user");
		DaoService d = DaoServiceProvider.provideDaoInstance();
		try{
			if(d.userExists(newUser)){
		
			
			PrintWriter out = response.getWriter();
			out.println("user already exists - choose a new user name");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			
		} 
		else {
			d.insertIntoUserTable(newUser);
			HttpSession session = request.getSession(true);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/successfullSignup.html");
			rd.forward(request, response);
		}
		}
			catch (Exception e) {
		
				request.setAttribute("error", "Invalid Entry");
				HttpSession session = request.getSession(false);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
				
			}
		// if not - create a new user and disply welcome page
	}

}
