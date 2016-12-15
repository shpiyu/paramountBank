package com.beans;

import java.util.Calendar;

public class Transaction {

	private int id;
	private String type;
	private Calendar date;
	private double amount;

	static int tranSeq;
	static {
		tranSeq = 0;
	}

	public Transaction(String type, double amount, Calendar date) {

		this.id = tranSeq;
		this.type = type;
		this.amount = amount;
		this.date = date;
		tranSeq++;
	}

	public int getId() {
		return id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", amount=" + amount + ", date=" + date.getTime() + "]";
	}

}
