package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DbConnection {
	
	public static Connection getConnection(String email, String message) throws Exception	{
		Connection conn = null;
		try	{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
			String username = "db_user";
			String password = "password123";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			
			String InsertStatement = "Insert into signup (eMail, message) VALUES ('" + email + "','" + message + "')";
			
			System.out.println(InsertStatement);
			
			PreparedStatement posted = conn.prepareStatement(InsertStatement);
			
			posted.executeUpdate();
			
			System.out.println("Inserted");
			return conn;
		} catch (Exception e)	{
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}
	}
}
