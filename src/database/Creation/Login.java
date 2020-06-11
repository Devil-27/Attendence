package database.Creation;
import java.sql.Statement;
import java.util.*;

public class Login extends JDBCConnection
{
	public Login(String db) {
		super(db);
	}

	String emp_id=null;
	String Student_id=null;
	String User_name=null;
	String Password=null;
	
	static void user_input(char ch)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1 for student");
		System.out.println("2 for teacher");
		System.out.println("enter your Choice");
		 ch = sc. next(). charAt(0);
		switch(ch)
		{
		case 1: teacher();
		break;
		case 2: student();
		}
		sc.close();
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1 for student");
		System.out.println("2 for teacher");
		System.out.println("enter your Choice");
		char ch = sc. next(). charAt(0);
		  user_input(ch);
	}
	
	static void teacher()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your emp_id");
		String str=sc.next();
		System.out.println("enter your Username");
		String Username=sc.next();
		System.out.println("enter your password");
		String Username1=sc.next();
		
		final String query = "INSERT INTO Login(Emp_id, User_name, password) VALUES('str1', 'Username1', 'pass')";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
	}
	
	static void student()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your Student_id");
		String str=sc.next();
		System.out.println("enter your Username");
		String Username=sc.next();
		System.out.println("enter your password");
		String Username1=sc.next();
		final String query = "INSERT INTO Login(Student_id, User_name, password) VALUES('str1', 'Username1', 'pass')";
		Statement stmt = con.createStatement();
		int inserted = stmt.executeUpdate(query);
	}
}
