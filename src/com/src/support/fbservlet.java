package com.src.support;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class likesservlet
 */
public class fbservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fbservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int i=0;
		//Statement stmt=null;
		System.out.println("Connected Database Successfully");
		//int day = Integer.parseInt(request.getParameter("id"));
		//int count=Integer.parseInt(request.getParameter("wow"));
		
		try	{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
			String username = "db_user";
			String password = "password123";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected Database Successfully");
			String facebook=request.getParameter("fb_likes");
			 System.out.println("The number is: " +facebook);
			 //String count=request.getParameter("wow");
			 int r1=Integer.parseInt(facebook);
			 System.out.println("The number is: " + r1);
			 //int r2=Integer.parseInt(count);
			 
			 //int r1=Integer.parseInt(day);

			 //int r2=Integer.parseInt(count);
			//stmt=conn.createStatement();
			/*System.out.println("Fetching records without condition...");*/
			//String sql = "INSERT INTO likes (counts) VALUES ('"+count+"') where id="+day;
			PreparedStatement ps = conn.prepareStatement("INSERT INTO likes(fb,fav,total) VALUES(?,?,?)");
			//PreparedStatement stmt = conn.prepareStatement(sql);
		    //r = stmt.executeUpdate(sql);
			ps.setInt(1,r1);
			ps.setInt(2,0);
			ps.setInt(3,0);
			//ps.setInt(4,0);
			//ps.setInt(5,0);
			System.out.println("FbWorked Successfully");
			i = ps.executeUpdate();
			if(i!=0){
				System.out.println("FbData Inserted");
			}
			else{
				System.out.println("Insertion failed");
			}
			/*while(rs.next())
			{
				int id=rs.getInt("id");
				int count=rs.getInt("counts");
				 System.out.print("ID: " + id);
		         System.out.print(", Count: " + count);

			}
			rs.close();*/
			/*String InsertStatement = "Insert into likes (counts) VALUES ('" + counts + "')";
			System.out.println(InsertStatement);
			
			PreparedStatement posted = conn.prepareStatement(InsertStatement);
			
			posted.executeUpdate();
			
			System.out.println("Inserted");*/
			
		
		} catch (Exception e)	{
			throw new RuntimeException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
