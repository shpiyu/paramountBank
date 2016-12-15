package com.filters;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.beans.Transaction2;

/**
 * Servlet Filter implementation class TransferFilter
 */
@WebFilter("/TransferFilter")
public class TransferFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransferFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		int fromAccNo = Integer.parseInt(request.getParameter("acc1"));
		int toAccNo = Integer.parseInt(request.getParameter("acc2"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		//TODO add calendar date
		//Calendar date = new Calendar().getInstance();
		Transaction2 transaction = new Transaction2(fromAccNo,toAccNo,amount,Calendar.getInstance());
		request.setAttribute("transaction", transaction);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
