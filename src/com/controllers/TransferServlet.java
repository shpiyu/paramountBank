package com.controllers;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Transaction2;
import com.exceptions.AccountNotFoundException;
import com.providers.BankServiceProvider;
import com.services.BankService;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TransferServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Transaction2 transaction = (Transaction2) request.getAttribute("transaction");
		BankService b = BankServiceProvider.ProvideBankInstance();
		int from = transaction.getFromAcc();
		int to = transaction.getToAcc();
		double amount = transaction.getAmount();
		double balance = 0.0;
		Calendar date = transaction.getDate();
		b.transfer(from, to, amount);
		try {
			balance = b.balEnquiry(from);
		} catch (AccountNotFoundException e) {
			request.setAttribute("error", "Invalid Account Number");
			HttpSession session = request.getSession(false);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
		}
		
		request.setAttribute("trnsaction", transaction);
		request.setAttribute("balance", balance);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/successfullTransfer.jsp");
		rd.forward(request, response);
		
		
	}

}
