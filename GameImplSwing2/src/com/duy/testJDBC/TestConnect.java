package com.duy.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnect {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/chess?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try {
			System.out.println("Connecting to Database Chess " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Success connected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
