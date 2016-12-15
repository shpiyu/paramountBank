package com.services;
import com.exceptions.AccountNotFoundException;
import com.exceptions.LowBalanceException;
import com.exceptions.LowOpeningAmountException;

public interface BankService {
	
	public int openAcc(String accType, double openingAmt, int uid) throws LowOpeningAmountException ;
	
	public void withdraw(int accNo, double amt) throws AccountNotFoundException, LowBalanceException;
	
	public void deposit(int accNo, double amt) throws AccountNotFoundException;
	
	public double balEnquiry(int accNo) throws AccountNotFoundException;
	
	public void transfer(int fromAccNo, int toAccNo, double amt);
	
	public void miniStatement(int accNo) throws AccountNotFoundException;
	
	

}
