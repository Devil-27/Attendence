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
		
		System.out.println("enter your Name");
		String name=sc.next();
		System.out.println("Enter you Employee id");
		String emp=sc.next();
		System.out.println("Enter your department_Id");
		String dept = sc.next();
		System.out.println("Enter your Student's ID ");
		String stu_id = sc.next();
		
		attendence_marking(name , emp , dept , stu_id);
		
	}
	
	public void attendence_marking(String name , String emp , String dept , String stu_id ) throws SQLException
	{
		
		final String query = "INSERT INTO Teacher(Student_id , Department_id , Emp_id , Emp_name ) VALUES( 'stu_id', 'dept','emp_id' , 'name' )";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
		System.out.println(inserted + "  Teacher database update;");
		
	}
	

}