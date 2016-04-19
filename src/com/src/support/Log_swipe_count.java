package com.src.support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Log_swipe_count
 */
public class Log_swipe_count extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Log_swipe_count.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log_swipe_count() {
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
		String val1=request.getParameter("co");
		String ip=request.getParameter("ip_addr");
		String id=request.getParameter("id");
		
		Log_swipe_count obj1=new Log_swipe_count();
		obj1.runMe1(ip,id,val1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void runMe1(String parameter1,String parameter2,String parameter3){
		if(log.isInfoEnabled()){
			log.info( parameter1+"\t"+parameter2+"\t"+parameter3);
		}
	}
}
