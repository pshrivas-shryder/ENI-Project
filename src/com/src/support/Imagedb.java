package com.src.support;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class Imagedb extends HttpServlet{
	
	
	
@SuppressWarnings("unused")
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//PrintWriter pw = response.getWriter();
	String driverName = "com.mysql.jdbc.Driver";
	  String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
	  //String dbName = "eni_support";
	  String userName = "db_user";
	     String password = "password123";
	       Connection con = null;
	       String imgLen="";
	       String imageid = request.getParameter("id");
	       //System.out.println("imageid"+imageid);
	       try{  
	    	   
	    	  
	    	   Class.forName(driverName);
	 	       con = DriverManager.getConnection(url,userName,password); 
//Statement st1=con.createStatement();
//String sql = "select myimage from pictures where pic_id='"+imageid+"'";
//String sql = "select image from carou4 where imgid='"+imageid+"'";
String sql = "select image from carousel_three where imgid='"+imageid+"'";
//String sql = "select image from carousel_three ";
   
PreparedStatement st2 = con.prepareStatement(sql);
ResultSet rs1 = st2.executeQuery(sql);


int imageCount = Integer.parseInt(imageid);

/*while( imageCount > 1){
	
	rs1.next();
//while(rs1.next() ){	
	//imageCount--;
	imageCount--;
	System.out.println("imagecount"+imageCount);
}*/

if(rs1!=null){

	rs1.next();
/*System.out.println(imgLen.length());
} 
rs1 = st1.executeQuery("select myimage from pictures");*/
	imgLen = rs1.getString(1);



InputStream readImg = rs1.getBinaryStream(1);
//System.out.println(readImg);
int size = 0;
int len=(int)imgLen.length();
//System.out.println("len"+len);

//byte[] rb = (byte[]) request.getAttribute("cid");
byte [] rb = new byte[10245678];
//int index=readImg.read(rb, 0, len); 
//System.out.println("index"+index);
response.reset();
response.setContentType("image/jpg");
while((size = readImg.read(rb)) != -1 ){
//	System.out.println("size"+size);
response.getOutputStream().write(rb,0,len);
}


}response.getOutputStream().flush(); 
rs1.close();



con.close();




} catch (Exception e){
e.printStackTrace();
}
}
}