package com.providers;

import java.io.FileInputStream;
import java.util.Properties;

import com.daoServices.DaoService;

public class DaoServiceProvider {

	public static DaoService provideDaoInstance() {

		try {
			FileInputStream fis = new FileInputStream("/home/piyush/workspace/NewBank/resources/DatabaseInfo.properties");
			Properties p = new Properties();
			p.load(fis);
			Class c = Class.forName(p.getProperty("DaoService"));
			DaoService d = (DaoService) c.newInstance();
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
