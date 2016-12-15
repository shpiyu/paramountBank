package com.providers;

import java.io.FileInputStream;
import java.util.Properties;

import com.services.BankService;

public class BankServiceProvider {

	public static BankService ProvideBankInstance() {
		Class c = null;
		BankService b = null;
		String bankService = "";
		try {

			FileInputStream fis = new FileInputStream("/home/piyush/workspace/NewBank/resources/BankInfo.properties");
			Properties p = new Properties();
			p.load(fis);
			bankService = p.getProperty("bankservice");
			c = Class.forName(bankService);
			b = (BankService) c.newInstance();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return b;
	}

}
