package com.src.support;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class ServletForImage
 */
public class ServletForImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	try
		{
		  String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
			String username = "db_user";
			String password = "password123";
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			
			String filePath = "C:/images";

            File path = new File(filePath);
           
            String[] pathList = path.list();
             String query = "insert into images (image_flag, image) values(?,?)";
          
            for (int i = 0; i < pathList.length; i++) {
              String filepath =filePath+"/"+ pathList[i];
               System.out.println(filePath+"/"+ pathList[i]);
              FileInputStream inputStream = new FileInputStream (new File(filepath));

                 // creating prepared statement
                 PreparedStatement ps = conn.prepareStatement(query);
                 ps.setInt(1, 1);
                 ps.setBinaryStream(2, (InputStream) inputStream, filepath.length());

                 // Executing the prepared Statement
                 int rows = ps.executeUpdate();
                 if (rows > 0) {
                      System.out.println("Image Inserted Successfully");
                 }
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Function Completed");
		}*/
		String connectionURL = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
		  String userName = "db_user";
		  String password = "password123";
		  java.sql.Connection con=null;
		  try{  
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  con=DriverManager.getConnection(connectionURL,userName,password);  
		  Statement st1=con.createStatement();
		  ResultSet rs1 = st1.executeQuery("select image from"+
		    " images where image_id='1'");
		  String imgLen="";
		  if(rs1.next()){
		  imgLen = rs1.getString(1);
		  System.out.println(imgLen.length());
		  }  
		  rs1 = st1.executeQuery
				   ("select image from images where image_id='1'");
				  if(rs1.next()){
				  int len = imgLen.length();
				  byte [] rb = new byte[len];
				  InputStream readImg = rs1.getBinaryStream(1);
				  int index=readImg.read(rb, 0, len);  
				  System.out.println("index"+index);
				  st1.close();
				  response.reset();
				  response.setContentType("image/jpg");
				  response.getOutputStream().write(rb,0,len);
				  response.getOutputStream().flush();  
				  }
				  }
				  catch (Exception e){
				  e.printStackTrace();
				  }
		

		
	

	
	}
}
