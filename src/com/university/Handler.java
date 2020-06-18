package com.university;
import java.sql.SQLException;
import java.util.*;
import com.login.Login;

public class Handler {
	Scanner sc=new Scanner(System.in);
	Login log = new Login();

	public static void main(String [] args)
	{
		Handler hand = new Handler();
		
		
		try 
		{
			
			hand.userInput();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();								// TODO Auto-generated catch block
		}
	}
	
	
	public void userInput() throws SQLException
	{
		System.out.println("1 for old user");
		System.out.println("2 for new user");
		System.out.println("enter your Choice");
		 int ch=sc.nextInt();
		switch(ch)
		{
		case 1: old_user();
		break;
		case 2: new_user();
		break;
		
		}
	}
		


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
