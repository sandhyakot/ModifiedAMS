package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;




public class JdbcConnection 
{
	
	private static Connection connection;
	JdbcConnection()
	{
		//constructor
	}
	

	public static Connection getConn() throws ClassNotFoundException
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cybage","root","root");

		} 
		catch (SQLException e) 
		{
			System.out.println("SQL Exception");//logger.warning(e+" ");
		}

		return connection;

	}//getConn

}//class
