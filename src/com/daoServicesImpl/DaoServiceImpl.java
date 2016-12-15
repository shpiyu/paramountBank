package com.daoServicesImpl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.beans.Account;
import com.beans.Transaction;
import com.beans.User;
import com.daoServices.DaoService;

public class DaoServiceImpl implements DaoService {

	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	Properties p;

	public DaoServiceImpl() {
		try {
			FileInputStream fis = new FileInputStream("/home/piyush/workspace/NewBank/resources/DatabaseInfo.properties");
			p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pass = p.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertIntoAccountTable(Account acc, int uid) {
		try {
			pstmt = con.prepareStatement("insert into account values(?,?,?,?)");
			pstmt.setInt(1, acc.getAccNo());
			pstmt.setString(2, acc.getAccType());
			pstmt.setDouble(3, acc.getBalance());
			pstmt.setInt(4, uid);
			int updateCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateAccount(int accNo, double balance) {

		try {
			pstmt = con.prepareStatement("update account set balance=? where accNo = ?;");
			pstmt.setDouble(1, balance);
			pstmt.setInt(2, accNo);
			int updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Account searchAccountInDatabase(int accNo) {

		try {
			pstmt = con.prepareStatement("select * from account where accNo = ? ;");
			pstmt.setInt(1, accNo);
			rs = pstmt.executeQuery();
			int no = 0; // account number
			String accType = "";
			double balance = 0;
			while (rs.next()) {
				no = rs.getInt(1);
				accType = rs.getString(2);
				balance = rs.getDouble(3);
			}

			Account acc = new Account(accType, balance);
			acc.setAccNo(no);

			return acc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertIntoTransactionTable(Transaction t, Account acc) {

		try {
			pstmt = con.prepareStatement("insert into transactions values(?,?,?,?,?);");
			pstmt.setInt(1, t.getId());
			pstmt.setString(2, t.getType());
			pstmt.setDate(3, new Date(t.getDate().getTimeInMillis()));
			pstmt.setDouble(4, t.getAmount());
			pstmt.setInt(5, acc.getAccNo());

			int updateCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void showTransactions(int accNo) {

		try {
			pstmt = con.prepareStatement("select type,amount,date from transactions where accno = ?");
			pstmt.setInt(1, accNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String type = rs.getString(1);
				double amount = rs.getDouble(2);
				Date date = rs.getDate(3);

				System.out.println(type + " " + amount + " " + date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean validateUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		try {
			pstmt = con.prepareStatement("select password from user where username = ?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getString(1).equals(password)){
					System.out.println("validate jhalela\n");
					return true;
				}
				else
				{
					System.out.println("nai jhalela\n");
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("nai jhalela2\n");
		return false;
	}

	@Override
	public boolean userExists(User user) {
		
		String query = "select username from user";
		String username = user.getUsername();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				if(username.equals(rs.getString(1))){
					System.out.println("user present");
					return true;
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user not present");
		return false;
	}

	@Override
	public void insertIntoUserTable(User user) {
		
		String name = user.getName();
		String email = user.getEmailid();
		String username = user.getUsername();
		String password = user.getPassword();
		
		try {
			pstmt = con.prepareStatement("insert into user(username,password,name,email) values(?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			int updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean accountExists(int accNo) {
		try {
			pstmt = con.prepareStatement("select accNo from account");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(accNo == rs.getInt(1))
				{
				System.out.println("milela");
					return true;
				}
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("nai milela");
		return false;
	}

	@Override
	public int getIdOfUser(String username) {
		try {
			pstmt = con.prepareStatement("select uid from user where username = ?;");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			int uid=0;
			while(rs.next())
			{
				uid = rs.getInt(1);
			}
			return uid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
