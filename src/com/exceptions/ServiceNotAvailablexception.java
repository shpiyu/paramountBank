package com.exceptions;

public class ServiceNotAvailablexception extends Exception {
	
	String msg;

	public ServiceNotAvailablexception(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ServiceNotAvailablexception [msg=" + msg + "]";
	}
	
	

}
