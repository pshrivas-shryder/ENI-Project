package com.src.support;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogDemo
 */
public class LogDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logger logger=null;
    public void init(){
    	logger = Logger.getRootLogger();
    	BasicConfigurator.configure();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	      
	    response.setContentType("text/html");
	    String name = request.getParameter("key");
	    logger.setLevel(Level.INFO);
		//logger.debug("logging debug message");
		logger.info(name);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Example for log4j</title></head>");
		out.println("<body>");
		//out.println("Log4j w/o configuration file");
	    //out.println("Logger name ="+ logger.getName());
		//out.println("<B>Button ID : "+name);
	    //System.out.println(name);
		out.println("</body>");
		out.println("</html>");
	}
	
	

}
