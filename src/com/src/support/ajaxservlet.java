package com.src.support;

import java.awt.List;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class ajaxservlet
 */
public class ajaxservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Blob> bl;
	int imagecount=0;
	String driverName;
	String url;
	String userName;
	String password;
	Connection con = null;
	private Object results; 
	public void init() throws ServletException{
		 driverName = "com.mysql.jdbc.Driver";
		  url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
		  //String dbName = "eni_support";
		  userName = "db_user";
		      password = "password123";
		      	   
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			Class.forName(driverName);
	        con = DriverManager.getConnection(url,userName,password); 
	        String sql = "select img,content1 from carousel_two left join carousel_three on carousel_two.cid= '"+4+"'";
	         PreparedStatement stmt = con.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery();
	         response.setContentType("application/json");
	         response.setCharacterEncoding("UTF-8");
	         response.getWriter().write(new Gson().toJson(rs));    
	         }
		
			catch(Exception e){
	    		e.printStackTrace();
	   	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		
	}

}
