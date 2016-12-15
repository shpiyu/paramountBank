package com.exceptions;

public class AccountNotFoundException extends Exception {
	
	String msg;

	public AccountNotFoundException(String msg) {
		super();
		this.msg = msg;
	}



	@Override
	public String toString() {
		return "AccountNotFoundException [msg=" + msg + "]";
	}
	
	

}
