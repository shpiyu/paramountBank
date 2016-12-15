package com.beans;

import java.util.Calendar;

public class Transaction2 {
	
	private int id;
	private int fromAcc;
	private int toAcc;
	private double amount;
	private Calendar date;
	
	static int tranSeq;
	static{
		tranSeq = 0;
	}
	//TODO add date
	public Transaction2(int fromAcc, int toAcc, double amount, Calendar date) {
		this.id = tranSeq;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		this.date = date;
		tranSeq++;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}
	public int getToAcc() {
		return toAcc;
	}
	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction2 [id=" + id + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", amount=" + amount + ", date="
				+ date + "]";
	}
	
	
	
	
}
