package com.src.support;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



public class RetImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    final String DB_URL ="jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
	    final String User = "db_user";
	    final String Password = "password123";
	    try {
	        Class.forName(JDBC_DRIVER);
	        Connection conn = DriverManager.getConnection(DB_URL, User, Password);

	        PreparedStatement stmt = conn.prepareStatement("select img from imgtable");
	        stmt.setLong(1, Long.valueOf(request.getParameter("id")));
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            response.getOutputStream().write(rs.getBytes("img"));
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	}

	}
}

