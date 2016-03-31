package com.src.support;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;

import twitter4j.JSONArray;
import twitter4j.JSONObject;



public class Sampleimage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Blob> bl;
	int imagecount=0;
	String driverName;
	String url;
	String userName;
	String password;
	Object result;
	Connection con = null; 
	public void init() throws ServletException{
		 driverName = "com.mysql.jdbc.Driver";
		  url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
		  //String dbName = "eni_support";
		  userName = "db_user";
		      password = "password123";
		      	   
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @return 
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession myses = request.getSession(true);
       
       String imageid =  request.getParameter("id");
        
        ServletOutputStream o; 
        
        try {
        	 Class.forName(driverName);
             con = DriverManager.getConnection(url,userName,password); 
	         String sql = "select mid,img from carousel_two where cid= '"+imageid+"'";
	         PreparedStatement stmt = con.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery();
	         myses.setAttribute("lis",rs);      
	         String encoded =new String ();
	         o = response.getOutputStream();
	         JSONArray jArry=new JSONArray();
	         if(rs!=null )
			 {
		        while(rs.next()){ 
	         	 byte[] dbImageArr = rs.getBytes("img");
			     encoded=DatatypeConverter.printBase64Binary(dbImageArr);
	             JSONObject jObjd=new JSONObject();
	             jObjd.put("key", encoded);
	             jArry.put(jObjd);
	             }
	        }
	         
	        String json = new Gson().toJson(jArry);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        o.print(json);
	        o.flush();
	       
		           
	         
	         }catch (Exception e){
	    		e.printStackTrace();
	   	}
	}   
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doGet(request, response);
	}

}
