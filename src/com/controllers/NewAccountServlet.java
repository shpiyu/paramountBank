package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Account;
import com.beans.User;
import com.daoServices.DaoService;
import com.exceptions.LowOpeningAmountException;
import com.providers.BankServiceProvider;
import com.providers.DaoServiceProvider;
import com.services.BankService;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = (Account) request.getAttribute("account");
		
		BankService b = BankServiceProvider.ProvideBankInstance();
		DaoService d = DaoServiceProvider.provideDaoInstance();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("userdata");
		int uid = d.getIdOfUser(user.getUsername());
		try {
			b.openAcc(account.getAccType(), account.getBalance(),uid);
		} catch (LowOpeningAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("accoutn", account);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/successfulNewAccount.jsp");
		rd.forward(request, response);
		
		
	}

}
