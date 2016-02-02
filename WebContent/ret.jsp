<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
          pageEncoding="ISO-8859-1"%>
           <%@page trimDirectiveWhitespaces="true"%>
           <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                "http://www.w3.org/TR/html4/loose.dtd">
           
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     </head>
    <body>
     <%@ page import="java.io.*"%>
 <%@ page import="java.sql.*"%>
 <%@ page import="java.util.*"%>
  <%@ page import="java.text.*"%>
 <%@ page import="javax.servlet.*"%>
 <%@ page import="javax.servlet.http.*"%>
 <%@ page import="javax.servlet.http.HttpSession"%>
 <%@ page import ="java.awt.image.*"%>
  <%@ page import ="javax.imageio.ImageIO"%>
<%@ page import="javax.imageio.stream.ImageInputStream"%>
 <%@ page language="java"%>
 <%@ page session="true"%>
 <%
 try {
	 out.println("Retrieve Image Example!");
	  String driverName = "com.mysql.jdbc.Driver";
	  String url = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
	  String dbName = "eni_support";
	  String userName = "db_user";
	     String password = "password123";
	       Connection con = null;
	       Class.forName(driverName);
	      con = DriverManager.getConnection(url,userName,password);
	        Statement st = con.createStatement();
	    // PreparedStatement pre1 = con.prepareStatement("select image from images");
	 ResultSet rs1=st.executeQuery("select image from images ");
	while(rs1.next())   
	 { 
	           int size1=0;  
	          //InputStream sImage1;  
	          //  sImage1 = rs1.getBinaryStream("image");  
	           Blob sample = rs1.getBlob("image");
	           int blobLength = (int) sample.length();
	           int count = 0;
	           

               byte[] blobAsBytes = sample.getBytes(1, blobLength);
               System.out.println(blobAsBytes);
            	   InputStream in = new ByteArrayInputStream(blobAsBytes);
            	   ByteArrayInputStream imageStream = new ByteArrayInputStream(blobAsBytes);
            	   ImageInputStream imageInput = ImageIO.createImageInputStream(in);
            	   System.out.println("inputstream"+imageInput);
              // final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
            
              response.setContentType("image/jpg");  
              OutputStream resOutputStream = response.getOutputStream();
              
                count++;
                while((size1= imageInput.read(blobAsBytes))!= -1 ) { 
                	  final BufferedImage bufferedImage = ImageIO.read(in);
                	  System.out.println("bufferdimage"+bufferedImage);
                	if(bufferedImage!=null)
                	{
               ImageIO.write(bufferedImage, "jpg", new File("c:/images/test9.jpg"));
                	}
                	
                	
               }
                
                
               System.out.println(count);
               resOutputStream.flush(); 
               resOutputStream.close();
               in.close();
               imageInput.close();
               
	          //  System.out.println(sImage1);
	            
	/*	byte[] imageInByte;
		BufferedImage originalImage = ImageIO.read(new File(
				"c://p/1.jpg"));

		// convert BufferedImage to byte array
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();*/

		// convert byte array back to BufferedImage
		//InputStream in = new ByteArrayInputStream();
		/*BufferedImage bImageFromConvert = ImageIO.read(sImage1);*/
        /* System.out.println(bImageFromConvert);
		ImageIO.write(bImageFromConvert, "jpg", new File(
				"c://p/test9.jpg"));*/
			/*	System.out.println(sample.getBinaryStream());
				BufferedImage bufferedImage = null;
				
	           bufferedImage = ImageIO.read(sample.getBinaryStream());
                System.out.println(bufferedImage);
	            //outputStream = sample.setBinaryStream(0);

	            RenderedImage renderedImage = (RenderedImage)bufferedImage;

	            ImageIO.write(renderedImage, "JPG", new File(
	    				"c://p/test9.jpg"));*/
	 }
	con.close();
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
 out.clear(); 
 out = pageContext.pushBody();

%>


   </body>
     </html>
 
 