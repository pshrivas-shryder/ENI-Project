package com.src.support;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tweet
 */
public class Tweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tweet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		/*PrintWriter pr = response.getWriter();
		
		
		HttpSession session = request.getSession(false);
	       session.getAttribute("lis");
		
		
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/signin.jsp");
         rd.forward(request,response);*/
		

		
	}

	

	

}
