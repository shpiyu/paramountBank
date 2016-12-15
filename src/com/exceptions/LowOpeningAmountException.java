package com.exceptions;

public class LowOpeningAmountException extends Exception {
	
	String str;

	public LowOpeningAmountException(String str) {
		super();
		this.str = str;
	}

	@Override
	public String toString() {
		return "LowOpeningAmountException [str=" + str + "]";
	}
	
	

}
