package com.insertionanddisplay;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.dbconnection.JDBCConnection;

import java.text.SimpleDateFormat;


public class Attendencee
{
	
	JDBCConnection jdbc = new JDBCConnection("Attendance");
	Connection con = jdbc.testJDBCConnection();
	Scanner sc = new Scanner(System.in);

	
	 public void marking(String dept,String stuId,String emp)
	 {
		 Date objDate = new Date();
		 String strDateFormat = "dd-MMM-yyyy";
		 SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		 System.out.println(objSDF.format(objDate));
		 
		 System.out.print("Student id = "+ stuId + "Department id" + dept +"Teacher Id" + emp + " " );
		 boolean ch = sc.nextBoolean();
		 System.out.print(" Attendance = " +ch);
		 
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
