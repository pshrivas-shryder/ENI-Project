package com.src.support;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) {

		try {

			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File(
					"c://p/1.jpg"));

			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			System.out.println(imageInByte);
			baos.close();
			//String i = "0xffd8ffe000104a464946000101010048";
			 String i = "0xffd8ffe000104a46494600010100000100010000fffe003e43524541544f523a2067642d6a7065672076312e30" ;
			
				    byte[] b = new byte[i.length() / 2];
				    for (int j = 0; j < b.length; j++) {
				      int index = j * 2;
				      //int v = Integer.parseInt(i.substring(index, index + 2), 16);
				       b[j / 2] = (byte) ((Character.digit(i.charAt(j), 16) << 4)
			                    + Character.digit(i.charAt(j+1), 16));
				     // b[j] = (byte) data;
				    }
				    System.out.println(b);
				  
         
			// convert byte array back to BufferedImage
			/*InputStream in = new ByteArrayInputStream(b);
			BufferedImage bImageFromConvert = ImageIO.read(in);
           System.out.println(bImageFromConvert);
			ImageIO.write(bImageFromConvert, "jpg", new File(
					"c://p/new-test4.jpg"));*/
			
			try {
				java.sql.Blob blob = null;
				blob.setBytes(1,b);
			
			BufferedImage bufferedImage = null;
		       OutputStream outputStream = null;
		        
		            bufferedImage = ImageIO.read(blob.getBinaryStream());
                    System.out.println(bufferedImage);
		            outputStream = blob.setBinaryStream(0);

		            RenderedImage renderedImage = (RenderedImage)bufferedImage;
                    System.out.println( renderedImage);
		            ImageIO.write(renderedImage, "JPG", outputStream);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}