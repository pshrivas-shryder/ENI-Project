package com.src.support;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Gimage extends HttpServlet{
	
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//PrintWriter out = response.getWriter();
	String driverName = "com.mysql.jdbc.Driver";
	  String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
	  //String dbName = "eni_support";
	  String userName = "db_user";
	     String password = "password123";
	       Connection con = null;
	       String imageid = request.getParameter("id");
	       System.out.println("imageid"+imageid);
	       try{  
	    	   
	    	  
	    	   Class.forName(driverName);
	 	       con = DriverManager.getConnection(url,userName,password); 
//Statement st1=con.createStatement();
//String sql = "select myimage from pictures where pic_id='"+imageid+"'";
String sql = "select img from carou3 where cid= '"+imageid+"'";
//String sql = "select img from carou3 where cid= 1";
   
PreparedStatement st2 = con.prepareStatement(sql);
ResultSet rs1 = st2.executeQuery(sql);
System.out.println("resultset "+rs1);
String imgLen="";
int id =0;
ArrayList  array = new ArrayList<>(); 
if(rs1!=null){
	while(rs1.next()){

		
byte[] rb = rs1.getBytes(1);
array.add(rb);
//array.
response.setContentType("image/jpg");
response.setContentLength(rb.length);
for(int i =0;i<rb.length;i++){
	//for(int i =0;i<array.size();i++){
	response.getOutputStream().write((rb));

}

response.getOutputStream().flush();

		}
	
}
	

//response.reset();
 
rs1.close();



con.close();




} catch (Exception e){
e.printStackTrace();
}
	      
}
}