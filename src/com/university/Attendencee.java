package com.university;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Attendencee
{
	
	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);


	public static void main(String[] args) throws SQLException
	{
		Attendencee atd = new Attendencee();
		atd.input();
				
	}
	
	 public void input() throws SQLException
	{
		 System.out.println("Enter your Employee Id");
		 String emp = sc.next();
		System.out.println("Enter your department_Id");
		String dept = sc.next();
		System.out.println("Enter your Student's ID ");
		String stuId = sc.next();
		System.out.println("Enter Attendence");
		char ch = sc.next().charAt(0);
		
		marking(dept,stuId,ch,emp);
		
	}
	 
	 public void marking(String dept,String stuId, char ch,String emp)
	 {
		 Date objDate = new Date();
		 String strDateFormat = "dd-MMM-yyyy";
		 SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		 System.out.println(objSDF.format(objDate));
		 
		 
		 try {
			 
			final String query = "INSERT INTO attendance(student_id,emp_id,department_id,attendance_marked) VALUES( '" + stuId + "','" + emp + "', '" + dept + "','"+ ch +"' )";
			Statement stmt = con.createStatement();
			
				int inserted = stmt.executeUpdate(query);
				System.out.println(inserted+ "attendance Marked");
			
		 }
		 
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
	 }
}
