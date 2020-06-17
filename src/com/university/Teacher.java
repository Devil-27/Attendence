package com.university;
import java.sql.*;
import java.util.*;

public class Teacher
{

	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);


	public static void main(String[] args) throws SQLException
	{
		Teacher teach = new Teacher();
		teach.input();
				
	}
	
	 public void input() throws SQLException
	{
		 
		System.out.println("enter your UserName");
		String name=sc.next();
		System.out.println("Enter you Employee id");
		String emp=sc.next();
		System.out.println("enter your name");
		String ename = sc.next();
		System.out.println("Enter your department_Id");
		String dept = sc.next();
		System.out.println("Enter your Student's ID ");
		String stu_id = sc.next();
		
		
		
		attendence_marking(name , emp , dept , stu_id , ename);
		
	}
	
	public void attendence_marking(String name , String emp , String dept , String stu_id , String ename ) throws SQLException
	
	{

		final String query = "INSERT INTO teacher(uname,student_id,department_id,emp_id,emp_name ) VALUES( '" + name + "','" + stu_id + "', '" + dept + "','" + emp + "','" + ename + "' )";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + "  Teacher database update;");
		
	}
	
/*	public void class_details()
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

	}*/
	

}