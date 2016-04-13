package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class imgtable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		createTable();

	}
	/*public static void post() throws Exception
	{
		final longblob image="C:\Users\Hp\workspace\ENI-Project\images\17.jpg";
						
		try
		{
			Connection con=getConnection();
			PreparedStatement create =con.prepareStatement("INSERT INTO imgtable (img) values('"+image"')");
			posted.executeUpdate();

			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Insert Completed");
		}
	}*/
	
	
	
	public static void createTable() throws Exception
	{
		try
		{
			Connection con=getConnection();
			PreparedStatement create =con.prepareStatement("CREATE TABLE IF NOT EXISTS images(image_id int(11) NOT NULL AUTO_INCREMENT,image_flag int(11) NOT NULL,image longblob NOT NULL,PRIMARY KEY(image_id))");
			create.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Function Completed");
		}
	}
	public static Connection getConnection() throws Exception
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
			String username = "db_user";
			String password = "password123";
			
			Class.forName(driver);
			@SuppressWarnings("unused")
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

}
