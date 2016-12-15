package com.beans;

import java.util.ArrayList;

public class Account {
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", balance=" + balance + ", transactions="
				+ transactions + "]";
	}

	private int accNo;
	private String accType;
	private double balance;

	ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	static int accSeq;

	static {
		accSeq = 10001;
	}

	public Account(String accType, double balance) {
		this.accNo = accSeq;
		this.accType = accType;
		this.balance = balance;
		accSeq++;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void saveTransaction(Transaction t) {
		this.transactions.add(t);
	}

	public void showTransactions() {
		for (Transaction t : transactions) {
			System.out.println(t);
		}
	}

}
