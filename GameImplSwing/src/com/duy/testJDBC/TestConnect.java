package com.duy.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnect {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_17d35cd59aca06e?useSSL=false";
		String user = "bf820aedc1c700";
		String pass = "f29cb098";

		try {
			System.out.println("Connecting to Database Chess " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Success connected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
