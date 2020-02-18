package com.cpg.sprint1.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {
	private static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sprint1","sprint1");
			System.out.println("Connected|!!!!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
