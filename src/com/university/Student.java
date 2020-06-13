package com.university;
import java.sql.*;
import java.util.*;
public class Student {
	

	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);


	public static void main(String[] args) throws SQLException
	{
		Student stu = new Student();
		stu.input();
				
	}
	
	 public void input() throws SQLException
	{
		 
		System.out.println("enter your name");
		String name = sc.next();
		System.out.println("Enter your department_Id");
		String dept = sc.next();
		System.out.println("Enter your Student's ID ");
		String stuId = sc.next();
		
	    
	     dataInsertion(name,dept,stuId);
	     show();
	
	}
	 
	public void dataInsertion(String name,String dept,String stuId)
	 {
		
		try 
		{

			final String query = "INSERT INTO student(student_id,student_name,department_id ) VALUES( '" + stuId + "','" + name + "', '" + dept + "' )";
			Statement stmt = con.createStatement();
			int inserted = stmt.executeUpdate(query);
			System.out.println( inserted + "data inserted");
		
		} 
		catch (SQLException e)  
		{
			                            // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	
	public void show() throws SQLException
	{

		final String query = "SELECT * FROM  student";
		
		Statement stmt = con.createStatement();
		
		ResultSet rs= stmt.executeQuery(query);
		
				while(rs.next()!=false)
				{
				
					String n = rs.getString(1);
					String str = rs.getString(2);
					String pass = rs.getString(3);
					System.out.println("Student Id = " + n + ", Student Name = " + str.trim() + ", Department Id = " + pass.trim());
			
				}
		}
			
		
	}
