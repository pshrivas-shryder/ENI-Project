package com.src.support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
/**
 * Servlet implementation class Log_click_count1
 */

public class Log_click_count1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(Log_click_count1.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log_click_count1() {
        super();
        
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BasicConfigurator.configure();
		//logger.setAdditivity(false);
		String val=request.getParameter("count");
		MDC.put("ip",request.getParameter("ip_addr"));
		Log_click_count1 obj=new Log_click_count1();
		obj.runMe(val);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void runMe(String parameter){
		if(logger.isInfoEnabled()){
			logger.info("Click count " + parameter);
		}
	}

}
