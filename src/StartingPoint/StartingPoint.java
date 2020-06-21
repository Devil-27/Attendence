package StartingPoint;

import java.sql.SQLException;

import com.utility.Handler;

public class StartingPoint {
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
}
