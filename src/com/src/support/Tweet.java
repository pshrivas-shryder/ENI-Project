package com.src.support;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Tweet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
PrintWriter pw = response.getWriter();
int i = 0 ;

Connection con=null;
try{
	 String driverName = "com.mysql.jdbc.Driver";
	  String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
	 // String dbName = "eni_support";
	  String userName = "db_user";
	     String password = "password123";
	      
	       Class.forName(driverName);
	      con = DriverManager.getConnection(url,userName,password);

String filePath = "C:/Users/ramya/Downloads/images";
File file = new File(filePath);
String[] pathList = file.list();
System.out.println(pathList.length);
for(int j=1;j<=pathList.length;j++){
	
	 String filepath =filePath+"/"+ pathList[j];
	 System.out.println( filepath);
	FileInputStream fs = new FileInputStream(filepath);
	PreparedStatement ps = con.prepareStatement("INSERT INTO carou1 VALUES(?,?)");
//ps.setInt(1,j);
ps.setInt(1,j);
ps.setBinaryStream(2,fs,fs.available());


 i = ps.executeUpdate();}

if(i!=0){
pw.println("image inserted successfully");
}else{
pw.println("problem in image insertion");
} 

} catch (Exception e){
System.out.println(e);
}
}
}
