package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
	
	public static Connection getConnection() throws Exception	{
		try	{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
			String username = "db_user";
			String password = "password123";
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connected");
			return conn;
		} catch (Exception e)	{
			throw new RuntimeException(e);
		}
	}
}
