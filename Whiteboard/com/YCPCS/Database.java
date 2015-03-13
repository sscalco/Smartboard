package com.YCPCS;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Database(){
		
	}
	
	public void makeConnection() throws ClassNotFoundException{
		Connection conn = null;
		try {
			//Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(true);
	
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
