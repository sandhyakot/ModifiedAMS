package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import model.User;

public class ValidatorDao
{
	private Connection conn;
	private ResultSet rst;
	PreparedStatement pst1;
	User u;
	public ValidatorDao() throws ClassNotFoundException 
	{
		conn=JdbcConnection.getConn();
	}
	public void cleanUp() throws SQLException 
	{
		//if prepared statement not null closing prepared statement
		if (pst1 != null)
			pst1.close();
		if (rst != null)
			rst.close();

		conn.close();//connection close

	}
	public User validate(String userid) {//is employee name is unique or not
	//Logger logger = Logger.getLogger(BookAppointmentDao.class.getName());
		try {
			pst1 = conn.prepareStatement("Select * from users where userid=(?)");
			pst1.setString(1, userid);
			rst=pst1.executeQuery();

			if(rst.next())
			{
				u = new User(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4)); 

			}
			} 
		catch (SQLException e) 
			{//handal sqlException  
			//logger.warning(e+" ");
			System.out.println("SQL Exception");
			}
	

		//closing the connections
		try 
		{
			cleanUp();
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL Exception");
			//logger.warning(e+" ");
		}
		return u; //return user

	}

}
