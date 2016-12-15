package com.controllers;

import java.io.IOException;

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
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getAttribute("user");
		DaoService d = DaoServiceProvider.provideDaoInstance();
		try{
			if(d.validateUser(user)){
		
			HttpSession session = request.getSession(true);
			
			session.setAttribute("userdata", user);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			
		}
		else{
			
		request.setAttribute("error", "Invalid Username or Password");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			HttpSession session = request.getSession(false);
			rd.include(request, response);
		}
		
		
	}
		catch(ServletException e1)
		{
			throw new ServletException("Some Problem",e1);
		}
	}

}
