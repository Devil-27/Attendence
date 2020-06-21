package com.utility;
import java.sql.SQLException;
import java.util.*;

import com.insertionanddisplay.*;
import com.utility.Login;

public class Handler {
	Scanner sc=new Scanner(System.in);
	Login log = new Login();
	Student stu = new Student();
	Teacher teach = new Teacher();
	
	
	
	public void userInput() throws SQLException
	{
		System.out.println("1 for old user");
		System.out.println("2 for new user");
		System.out.println("3 for Admin");
		System.out.println("enter your Choice");
		 int ch=sc.nextInt();
		switch(ch)
		{
		case 1: old_user();
		break;
		case 2: new_user();
		break;
		case 3: admin();
		break;
		
		}
	}
	
		/*
		 * This function is use to update both the table student and teacher in the database.
		 * With the teach.input we calling the input function of the teacher class.
		 * with the help of stu.student we are calling the input function of the student class for insertion of data in database.
		 */
	
		public void admin() throws SQLException
		{
			
			System.out.println("enter 1 for update the teacher table");
			System.out.println("Enter 2 for update the student table");
			int ch = sc.nextInt();
			switch(ch)
			{
			case 1:teach.input();
				break;
			case 2:stu.input();
				break;
			}
			
		}
		/**
		 * this function is use to login the database 
		 * it help to call the teacher data and student function from the login class.
		 * this function is deal with only login class function.
		 * @throws SQLException
		 */

	public void old_user() throws SQLException
	{
		System.out.println("you are:");
		System.out.println("1: Teacher");
		System.out.println("2: Student");
		
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		
		switch(ch)
		{
		
			case 1: log.teacherData();
				break;
			case 2: log.studentData();
				break;
				
		}
		
	}
	/**
	 * this function is use to insert the data in the login table of teacher and student.
	 * this function not upgrade the main teacher and student table;
	 * this function only deal with the login class functions.
	 * @throws SQLException
	 */
	public void new_user() throws SQLException
	{
		
		System.out.println("you are:");
		System.out.println("1: Teacher");
		System.out.println("2: Student");
		
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		
		switch(ch)
		{
			case 1: log.teacher();
				break;
			case 2: log.student();
				break;
		}
		
		
	}
	
}
