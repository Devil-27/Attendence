package com.insertionanddisplay;
import java.sql.*;
import java.util.*;

import com.dbconnection.JDBCConnection;

public class Teacher
{

	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);


	
	public void choice()throws SQLException
	{	System.out.println("What do you want to do: ");
	System.out.println("1 for check your Class details");
	System.out.println("2 for check your Class attendence");
	System.out.println("Enter your preferance");
	int ch = sc.nextInt();
	switch(ch)
	{
	
	case 1: class_details();
		break;
	case 2:attendence();
		break;
	
	}
		}

	public void input() throws SQLException
	{
		 
		System.out.println("enter your UserName");
		String name = sc.next();
		System.out.println("Enter you Employee id");
		String emp = sc.next();
		System.out.println("enter your name");
		String ename = sc.next();
		System.out.println("Enter your department_Id");
		String dept = sc.next();
		System.out.println("Enter your Student's ID ");
		String stuId = sc.next();
		final String query = "INSERT INTO teacher(uname,student_id,department_id,emp_id,emp_name ) VALUES( '" + name + "','" + stuId + "', '" + dept + "','" + emp + "','" + ename + "' )";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + "  Teacher database update;");
		
		
	}
	
	/**
	 * attendence function is user to marked the attendance and update the attendance table.
	 * @throws SQLException
	 */
	
	public void attendence() throws SQLException
	{
	final String query = "SELECT * FROM  teacher ";
		
		Statement stmt;
			stmt = con.createStatement();
		
		ResultSet rs= stmt.executeQuery(query);
		
				while(rs.next()!=false)
				{
				
					String uname = rs.getString(1); 			// Assign the userName in uname.
					String str = rs.getString(2); 			// ASsing the Student_id in str.
					String dept = rs.getString(3); 			//Assign the Department id in dept.
					String eid = rs.getString(4); 			//Assign the employee id to eid.
					String name = rs.getString(5); 			//Assign the Employee name to name.
					
					attendence_marking(uname , str , dept , eid , name);
				}
	}
	
	
	/**
	 * this function is used to call the function void marking of the attendance to update the attendance table in the database. 
	 * @param name
	 * @param emp
	 * @param dept
	 * @param stu_id
	 * @param ename
	 * @throws SQLException
	 */
	public void attendence_marking(String name , String emp , String dept , String stu_id , String ename ) throws SQLException
	
	{
		Attendencee atd = new Attendencee();
		atd.marking( dept , stu_id , ename );
		
	}
	
	public void class_details()
	{
		try {
		final String query = "SELECT * FROM  teacher ";
		
		Statement stmt;
			stmt = con.createStatement();
		
		ResultSet rs= stmt.executeQuery(query);
		
				while(rs.next()!=false)
				{
				
					String n = rs.getString(1);
					String str = rs.getString(2);
					String pass = rs.getString(3);
					String eid = rs.getString(4);
					String name = rs.getString(5);
					System.out.println("Username = " + n + ", Student_id = " + str.trim() + ", Department Id = " + pass + "Employee_id = " + eid + "Employee Name = " +name );
				}
			}
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	}

	

}