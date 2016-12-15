package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.AccountNotFoundException;
import com.providers.BankServiceProvider;
import com.services.BankService;


@WebServlet("/EnquiryServlet")
public class EnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EnquiryServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	{	
		int accNo = Integer.parseInt(request.getParameter("accountNumber"));
		double balance=0.0;
		BankService b = BankServiceProvider.ProvideBankInstance();
		
		try {
			balance = b.balEnquiry(accNo);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("error", "Invalid account number");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/enquiry.jsp");
			rd.include(request, response);
		}
		request.setAttribute("balance", balance);
		request.setAttribute("accNo", accNo);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/successfulEnquiry.jsp");
		rd.forward(request, response);
	
	}
	
	}
}
