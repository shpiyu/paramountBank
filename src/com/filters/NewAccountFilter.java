package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.beans.Account;

/**
 * Servlet Filter implementation class NewAccountFilter
 */
@WebFilter("/NewAccountFilter")
public class NewAccountFilter implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		String accountType = request.getParameter("accounType");
		Double balance = Double.parseDouble(request.getParameter("openingBalance"));
		Account account = new Account(accountType, balance);
		System.out.println("acc det"+account);
		request.setAttribute("account", account);
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
