package com.src.support;

import java.io.IOException;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.stanford.nlp.io.EncodingPrintWriter.out;

/**
* Servlet implementation class Displayimage
*/
public class Rimage extends HttpServlet {
private static final long serialVersionUID = 1L;
ArrayList<Blob> bl;
int imagecount=0;
String driverName;
String url;
String userName;
String password;
Connection con = null; 
public void init() throws ServletException{
	 driverName = "com.mysql.jdbc.Driver";
	  url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
	  //String dbName = "eni_support";
	  userName = "db_user";
	      password = "password123";
	      	   
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
	 HttpSession myses = request.getSession(true);
	        
	       String imageid = request.getParameter("id");
	      // String subImage = request.getParameter("subid");
	       System.out.println("imageid"+imageid);
	       //System.out.println("sub imageid"+subImage);
	      
   // PrintWriter out = response.getWriter();

    ServletOutputStream o; 
    
    try {

    	 Class.forName(driverName);
	       con = DriverManager.getConnection(url,userName,password); 


    	//String sql = "select content1,img from carou3,carou1 where cid= '"+imageid+"'";
    	String sql = "select mid,img from carousel_two,carousel_three where cid= '"+imageid+"'";
    	  
    PreparedStatement stmt = con.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    

    myses.setAttribute("lis",rs);
    
    byte[] obj = new byte[1434295];
    byte[] sample = null;
    int srcPos = 0;
    imagecount++;
    if(rs!=null )
    {
    while(rs.next()){ 
    	
    	int id = rs.getInt(1);
    	System.out.println("id = "+id);
    	System.out.println("imagecount = "+imagecount);
    	
     
    	 /*if(id == Integer.parseInt(subImage)){
    
    		 response.setHeader("expires", "1"); 
    		// response.setH
    		 response.setContentType(rs.getString("content1"));*/
    	  
    	 

    
   
    sample = rs.getBytes("img");
    //o = response.getOutputStream();
    //o.write(sample);
    //o.flush();
    
    int length = sample.length;
    System.arraycopy(sample, 0, obj,srcPos, length);
    srcPos += length;
    	 }
    	// id++;
   // return;  
     }
    
  // }
  // if(id == imagecount){
    //	imagecount=0;
   //}
    	
    System.out.println("Lenght required = " + srcPos);
    if(rs!=null){
    o = response.getOutputStream();
    //o.write(rs.getBytes("img"));
    byte[] newArray = new byte[srcPos];
    System.arraycopy(obj, 0, newArray, 0, srcPos);
    o.write(newArray);
  /*  myses.setAttribute("lis",imagecount);
    RequestDispatcher rd=request.getRequestDispatcher("/audicar.jsp");
    rd.forward(request,response);*/
    
    //System.out.println("alert");
     
    o.flush();
    }
}catch (Exception e){
	e.printStackTrace();
	}
}
}