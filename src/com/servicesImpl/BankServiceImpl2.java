package com.servicesImpl;

import java.util.ArrayList;
import java.util.Calendar;

import com.beans.Account;
import com.beans.Transaction;
import com.daoServices.DaoService;
import com.exceptions.AccountNotFoundException;
import com.exceptions.LowBalanceException;
import com.exceptions.LowOpeningAmountException;
import com.providers.DaoServiceProvider;
import com.services.BankService;

public class BankServiceImpl2 implements BankService {

	Account acc;
	Transaction t;
	ArrayList<Account> accounts = new ArrayList<Account>();
	DaoService d = DaoServiceProvider.provideDaoInstance();

	@Override
	public int openAcc(String accType, double openingAmt, int uid) throws LowOpeningAmountException {
		if (openingAmt < 1000) {
			throw new LowOpeningAmountException("Minimum opening amount should be 1000");
		} else {
			System.out.println("HEEEELLLLOOOOOOOUUU");
			acc = new Account(accType, openingAmt);
			accounts.add(acc);
			d.insertIntoAccountTable(acc, uid);
			return acc.getAccNo();
		}
	}

	@Override
	public void withdraw(int accNo, double amt) throws AccountNotFoundException, LowBalanceException {
		// acc = findAcc(accNo);
		acc = d.searchAccountInDatabase(accNo);
		if (acc != null) {
			if (acc.getBalance() < amt)
				throw new LowBalanceException("Not enough balance");
			double bal = acc.getBalance() - amt;
			d.updateAccount(accNo, bal);
			// acc.setBalance(bal);
			// java.sql.Date date =new
			// java.sql.Date(System.currentTimeMillis());
			// Date date = new Date(System.currentTimeMillis());
			//t = new Transaction("withdraw", bal, Calendar.getInstance());
			// acc.saveTransaction(t);
			//d.insertIntoTransactionTable(t, acc);
		} else {
			throw new AccountNotFoundException("Account not found");
		}

	}

	@Override
	public void deposit(int accNo, double amt) throws AccountNotFoundException {
		// acc = findAcc(accNo);
		acc = d.searchAccountInDatabase(accNo);
		if (acc != null) {
			double bal = acc.getBalance();
			if (bal >= amt)
				d.updateAccount(accNo, bal + amt);
			// acc.setBalance(bal + amt);
			// java.sql.Date date =new
			// java.sql.Date(System.currentTimeMillis());
			// Date date = new Date(System.currentTimeMillis());
			//t = new Transaction("deposit", bal + amt, Calendar.getInstance());
			// acc.saveTransaction(t);
			//d.insertIntoTransactionTable(t, acc);
		} else {
			throw new AccountNotFoundException("Account not found");
		}

		// save in DB

	}

	@Override
	public double balEnquiry(int accNo) throws AccountNotFoundException {
		// acc = findAcc(accNo);
		if(d.accountExists(accNo))
		{	
			acc = d.searchAccountInDatabase(accNo);
			return acc.getBalance();
		}
		else
		{		
			System.out.println("not found exception thrown");
			throw new AccountNotFoundException("Account not found");
		}

	}

	@Override
	public void transfer(int fromAccNo, int toAccNo, double amt) {
		try {
			withdraw(fromAccNo, amt);
		} catch (AccountNotFoundException | LowBalanceException e) {
			e.printStackTrace();
		}

		try {
			deposit(toAccNo, amt);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// java.sql.Date date =new java.sql.Date(System.currentTimeMillis());
		// Date date = new Date(System.currentTimeMillis());
		//t = new Transaction("transfer", amt, Calendar.getInstance());
		// acc.saveTransaction(t);
		//d.insertIntoTransactionTable(t, acc);

	}

	public Account findAcc(int accNo) {
		for (Account a : accounts) {
			if (a.getAccNo() == accNo)
				return a;
		}
		return null;
	}

	@Override
	public void miniStatement(int accNo) throws AccountNotFoundException {
		// acc = findAcc(accNo);
		// if (acc != null) {
		// acc.showTransactions();
		// } else {
		// throw new AccountNotFoundException("Account not found");
		// }

		d.showTransactions(accNo);
	}

}
