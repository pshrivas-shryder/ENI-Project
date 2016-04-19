package com.src.support;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

/**
 * Application Lifecycle Listener implementation class ContextListener2
 *
 */
public class ContextListener2 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener2() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext context = sce.getServletContext();
    	String log4j1ConfigFile = context.getInitParameter("log4j1-config-location");
        String fullPath1 = context.getRealPath("") + File.separator + log4j1ConfigFile;
        PropertyConfigurator.configure(fullPath1);
    }
	
}
