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
	
	 void user_input() throws SQLException
	{
		System.out.println("1 for Teacher");
		System.out.println("2 for Student");
		System.out.println("enter your Choice");
		 int ch=sc.nextInt();
		switch(ch)
		{
		case 1: teacher();
		break;
		case 2: student();
		break;
		}
		
	}
	
	public static void main(String[] args) throws SQLException
	{
		
		Login lin=new Login();
		  lin.user_input();
	}
	
	 public void teacher() throws SQLException
	{
		
		System.out.println("enter your emp_id");
		emp_id=sc.next();
		System.out.println("enter your Username");
		 User_name=sc.next();
		System.out.println("enter your password");
		Password=sc.next();
		
		final String query = "INSERT INTO Login(User_name , Password , Emp_id ) VALUES( 'User_name', 'Password','emp_id')";
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
		final String query = "INSERT INTO Login( User_name, password,Student_id) VALUES('User_name', 'Password','Student_id' )";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + " database Updated");
		
}
}