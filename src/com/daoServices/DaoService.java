package com.daoServices;

import com.beans.Account;
import com.beans.Transaction;
import com.beans.User;

public interface DaoService {

	public void insertIntoAccountTable(Account acc, int uid) ;

	public void insertIntoTransactionTable(Transaction t, Account acc);

	public Account searchAccountInDatabase(int accNo);

	public void updateAccount(int accNo, double balance);

	public void showTransactions(int accNo);
	
	//validate user name and password
	public boolean validateUser(User user);
	
	//check for existing user
	public boolean userExists(User user);

	public boolean accountExists(int accNo);
	//create new user
	public void insertIntoUserTable(User user);
	
	public int getIdOfUser(String username);
}
