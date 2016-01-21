package com.src.support;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Main {
   public static void main(String args[]) throws IOException{
	   Properties pop = new Properties();
	   pop.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
	   FileWriter writer = new FileWriter("MyPropFile.properties");
	   pop.store(writer,"Author");
	   writer.close();
   }
}
