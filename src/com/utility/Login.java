package com.utility;
import java.sql.*;
import java.util.*;

import com.dbconnection.JDBCConnection;
import com.insertionanddisplay.Student;
import com.insertionanddisplay.Teacher;

public class Login 
{
	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);
	Teacher teach = new Teacher();
	Student st = new Student();

	String emp_id=null;
	String Student_id=null;
	String User_name=null;
	String Password=null;
	
	/**
	 * this function is used to call the choice function of the teacher class.
	 * After checking the username password and employee id
	 * @throws SQLException
	 */
	
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
				
				teach.choice();
				
			}
	}
	
	/**
	 * this function is used to access the student table and check the attendance and the details of the student.
	 * @throws SQLException
	 */
	
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
		final String query = "SELECT uname,pass,student_id FROM  login_student ";
		ResultSet rs= stmt.executeQuery(query);
	
			while(rs.next()!=false)
			{
			
				n = rs.getString(1);
				pass = rs.getString(2);
				student_id = rs.getString(4);
			}
			if(n==usr && pass == pas && student_id == emp )
			{
				st.choice();
				
			}
		
	}
	
	/**
	 * teacher function is use to insert the data of the login_teacher in the database.
	 * 
	 */
	
	 public void teacher() throws SQLException
	{
		
		System.out.println("enter your emp_id");
		emp_id=sc.next();
		System.out.println("enter your Username");
		 User_name=sc.next();
		System.out.println("enter your password");
		Password=sc.next();
		
		final String query = "INSERT INTO login(uname , pass, emp_id) VALUES( '" + User_name + "', '" + Password + "','" + emp_id + "')";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + " database Updated");
		
	}
	/**
	 * this function is use to insert the data inside the login_student database.
	 * @throws SQLException
	 */
	   public void student() throws SQLException
	{
		
		System.out.println("enter your Student_id");
		Student_id = sc.next();
		System.out.println("enter your Username");
		User_name = sc.next();
		System.out.println("enter your password");
		Password = sc.next();
		final String query = "INSERT INTO login_student( uname, password,student_id) VALUES('" + User_name + "', '" + Password + "','" + Student_id + "' )";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + " database Updated");
		
	}

}