package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author SUBBU
 */

public class InsertImages {
     static String URL = "jdbc:mysql://pshrivas-eni.cwgbkmxxzso1.ap-southeast-1.rds.amazonaws.com:3306/eni_support";
     static String userName = "db_user";
     static String password = "password123";
     public static void main(String[] args) {
          try {
              // Loads the MySQL Driver
              Class.forName("com.mysql.jdbc.Driver");

              // get's Connection by using DriverManager class
              Connection con = DriverManager.getConnection(
                        URL, userName, password);

              // images directory path
              String filePath = "C:/images";

              // Creating File object with directory path
              File path = new File(filePath);

              /*
               * getting the list of files path under
                * directory and saving into
               * String type of array
               */
              String[] pathList = path.list();
               String query = "insert into images (image_flag, image) values(?,?)";
              // Loading each file using for loop
              for (int i = 0; i < pathList.length; i++) {
                String filepath =filePath+"/"+ pathList[i];
                 System.out.println(filePath+"/"+ pathList[i]);
                FileInputStream inputStream = new FileInputStream (new File(filepath));

                   // creating prepared statement
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.setInt(1, 1);
                   ps.setBinaryStream(2, (InputStream) inputStream, filepath.length());

                   // Executing the prepared Statement
                   int rows = ps.executeUpdate();
                   if (rows > 0) {
                        System.out.println("Image Inserted Successfully");
                   }
              }
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          } catch (SQLException e) {
              e.printStackTrace();
          }
     }
}
