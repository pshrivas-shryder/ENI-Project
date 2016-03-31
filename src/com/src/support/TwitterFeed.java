package com.src.support;

import java.io.IOException;





import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.*;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import com.src.support.NLP;
import javax.servlet.AsyncListener;
import java.util.logging.Logger;



//@WebServlet(value="/WhatToThink",asyncSupported = true,loadOnStartup = 1 )
public class TwitterFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 final static ArrayList<String> tw =  new ArrayList<String>();
	// final ArrayList<String> tweetList =  new ArrayList<String>();
	 ConcurrentLinkedQueue<String> tweetList= new ConcurrentLinkedQueue<String>();
	 String token_access ="4742496138-p5i8hV1XdLsrgXuG1tYroXVHhzYJleG9hQqr08B";
	 String token_secret ="cObxsYcOZCrR7YqGdGmRmG9BxeHg9X94Ly9IFJXXJZMXW";
	 String consumer_key ="FZUl0OfzBpmE7O2lNEBTRHO5j";
     String consumer_secret="tKqz3qATAJz7EGMAX2OHMDnG6M1MREnf3WG9tK6EcunF45yw6Y";
      TwitterStream stream=null;
      ConfigurationBuilder cb=null;
      public void init() throws ServletException{
    	  
    	  if(cb==null){
    	  cb = new ConfigurationBuilder();
    	  
          cb.setDebugEnabled(true);
          cb.setOAuthConsumerKey(consumer_key);
          cb.setOAuthConsumerSecret(consumer_secret);
          cb.setOAuthAccessToken(token_access);
          cb.setOAuthAccessTokenSecret(token_secret);
          stream =    new TwitterStreamFactory(cb.build()).getInstance();
          System.out.println("padma");
          hello();
    	  }
         
  		
  		
      }
    
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		//PrintWriter out = response.getWriter();
		
		
	   // List<String> tweets = tweetList;
        NLP.init();    
        HttpSession myses = request.getSession();
        for(String tweet : tweetList) {
	        	if(NLP.findSentiment(tweet)>2)	{ 
	        		myses.setAttribute("lis",tweet);
	        		
	        	}
		    		 
		  	 		
        }
       
     
		RequestDispatcher rd=request.getRequestDispatcher("/test.jsp");
        rd.forward(request,response);
        
	  
	  
      
		   }     
	
	
	public void hello()
	{  
		    
		StatusListener listener = new StatusListener() {
            public void onStatus(Status status) {
           	 
	          tweetList.add(status.getText());
	         
    	        	  
	         
	          }

			@Override
			public void onException(Exception ex) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onScrubGeo(long userId, long upToStatusId) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStallWarning(StallWarning warning) {
				// TODO Auto-generated method stub
				
			} 
			


	    };
		

	               FilterQuery qry = new FilterQuery();
	               String[] key1 = { "@LEVIS","levis","Levi's" };
	               
	             

	               stream.addListener(listener);
	               qry.track(key1);
	               stream.filter(qry);
	               
	               
	               
	               try {
	       			Thread.sleep(1000);
	       		} catch (InterruptedException e1) {
	       			
	       			e1.printStackTrace();
	       		}
				
	              
	}
	
}

	
       

            
            
        
       
	

        
	


