package com.qa.ims.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import main.DBConfig;


public class DB {
	
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	public static final String DB_URL = "jdbc:mysql://localhost/charity?serverTimezone=UTC";
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//com.mysql.jdbc.Driver
	private static Connection conn = null;
	private static Statement stmt = null;
	
	
	
	  public static void connect() {
		  try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  
	  /*{ try { Class.forName(JDBC_DRIVER); } catch
	  (ClassNotFoundException e1) { e1.printStackTrace(); } try { conn =
	  DriverManager.getConnection(DB_URL, USER, USER); } catch (SQLException e) {
	  e.printStackTrace(); } try { stmt = conn.createStatement(); } catch
	  (SQLException e) { e.printStackTrace(); } }
*/	 
	
	/*
	 * static void exCreate(String query) { try { stmt = conn.createStatement(); }
	 * catch (SQLException e1) { e1.printStackTrace(); } try { stmt.execute(query);
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 */
	
	public static void exUpdate(String query) {
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet exQuery(String query) {
		ResultSet r = null;
		try {
			r = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
		
	
	
	public void close() throws SQLException {
		conn.close();
	}	
	
	
}
