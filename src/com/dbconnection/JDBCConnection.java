package com.dbconnection;
import java.sql.*;
public class JDBCConnection {
	private final String url;
	private final String user;
	private final String password;
	
	public JDBCConnection(String db) 
	{
		url = "jdbc:postgresql://localhost/" + db;
		user = "postgres";
		password = "1234";
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		JDBCConnection jdConnectionTest = new JDBCConnection("Attendance");
		Connection con = jdConnectionTest.testJDBCConnection();
		jdConnectionTest.testCRUDOperation(con, "count");
	}
	public void testCRUDOperation(Connection con, String operationType) throws SQLException {
		
		if(operationType.equalsIgnoreCase("insert")) {
		} 
	}
	
		public Connection testJDBCConnection() {
			Connection con = connect();
			return con;
		}
		
		public Connection connect() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");
	        } catch (SQLException e) {
	            System.out.println("Exception in DB connection caught : " + e.getMessage());
	        }

	        return conn;
	    }
		
	}