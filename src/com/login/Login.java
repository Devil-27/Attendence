package com.login;
import java.sql.*;
import java.util.*;

import com.university.JDBCConnection;

public class Login 
{
	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);

	String emp_id=null;
	String Student_id=null;
	String User_name=null;
	String Password=null;
	
	
	public void teacherData() throws SQLException
	{
		String n = null , pass = null , emp_id = null;
		System.out.println("Enter your username");
		String usr = sc.next();
		System.out.println("Enter your password");
		String pas = sc.next();
		System.out.println("Enter your Emp-id");
		String emp = sc.next();
		Statement stmt;
		stmt = con.createStatement();
		final String query = "SELECT uname,pass,emp_id FROM  login ";
		ResultSet rs= stmt.executeQuery(query);
	
			while(rs.next()!=false)
			{
			
				n = rs.getString(1);
				pass = rs.getString(2);
				emp_id = rs.getString(4);
			}
			if(n==usr && pass == pas && emp_id == emp )
			{
				final String query2 = "select * from teacher where emp='emp'";
				rs= stmt.executeQuery(query2);
				while(rs.next()!= false)
				{
					String q = rs.getString(1);
					String w = rs.getString(1);
					String e = rs.getString(1);
					String r = rs.getString(1);
					String t = rs.getString(1);
					System.out.println(" Username " + q + "Student id " + w + "Department id" + e + "Employee id" + r + "Employee Name" + t);
				}
			}
	}
	public void studentData()throws SQLException
	{
		String n = null , pass = null , student_id = null;
		System.out.println("Enter your username");
		String usr = sc.next();
		System.out.println("Enter your password");
		String pas = sc.next();
		System.out.println("Enter your Student-id");
		String emp = sc.next();
		Statement stmt;
		stmt = con.createStatement();
		final String query = "SELECT uname,pass,student_id FROM  login ";
		ResultSet rs= stmt.executeQuery(query);
	
			while(rs.next()!=false)
			{
			
				n = rs.getString(1);
				pass = rs.getString(2);
				student_id = rs.getString(4);
			}
			if(n==usr && pass == pas && student_id == emp )
			{
				final String query2 = "select * from student where student_id='stu'";
				rs= stmt.executeQuery(query2);
				while(rs.next()!= false)
				{
					String q = rs.getString(1);
					String w = rs.getString(2);
					String e = rs.getString(3);
					System.out.println("Student id " + q +  "student Name" + w + "Department id" + e);
				}
			}
		
	}
	
	
	 public void teacher() throws SQLException
	{
		
		System.out.println("enter your emp_id");
		emp_id=sc.next();
		System.out.println("enter your Username");
		 User_name=sc.next();
		System.out.println("enter your password");
		Password=sc.next();
		
		final String query = "INSERT INTO login(uname , pass, emp_id,lid) VALUES( '" + User_name + "', '" + Password + "','" + emp_id + "',9)";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + " database Updated");
		
	}
	
	   public void student() throws SQLException
	{
		
		System.out.println("enter your Student_id");
		Student_id = sc.next();
		System.out.println("enter your Username");
		User_name = sc.next();
		System.out.println("enter your password");
		Password = sc.next();
		final String query = "INSERT INTO login( uname, pass,student_id,lid) VALUES('" + User_name + "', '" + Password + "','" + Student_id + "',9 )";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + " database Updated");
		
	}

}