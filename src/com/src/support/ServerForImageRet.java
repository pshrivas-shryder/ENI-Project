package com.src.support;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServerForImageRet
 */
public class ServerForImageRet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerForImageRet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* String connectionURL = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
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
				  }*/
				  }
				
	

	
	

}
