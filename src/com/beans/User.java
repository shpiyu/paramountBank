package com.beans;

public class User {
	int uid;
	String username;
	String password;
	String name;
	String emailid;
	
	//to be used at the time of login
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	//to be used during sign up
	public User(String username, String password, String name, String emailid) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.emailid = emailid;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", emailid=" + emailid
				+ "]";
	}
	
	
	
	

}
