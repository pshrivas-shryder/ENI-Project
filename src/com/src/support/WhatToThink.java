package com.src.support;

import java.io.IOException;





import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class WhatToThink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

	      
	      final PrintWriter out = response.getWriter();
		
		
		
		final ArrayList<String> tweetList =  new ArrayList<String>();
		final ArrayList<String> tw =  new ArrayList<String>();
		
        String token_access ="4742496138-p5i8hV1XdLsrgXuG1tYroXVHhzYJleG9hQqr08B";
		String token_secret ="cObxsYcOZCrR7YqGdGmRmG9BxeHg9X94Ly9IFJXXJZMXW";
		String consumer_key ="FZUl0OfzBpmE7O2lNEBTRHO5j";
        String consumer_secret="tKqz3qATAJz7EGMAX2OHMDnG6M1MREnf3WG9tK6EcunF45yw6Y";
		
        ConfigurationBuilder cb = new ConfigurationBuilder();
		                     cb.setDebugEnabled(true);
		                     cb.setOAuthConsumerKey(consumer_key);
		                     cb.setOAuthConsumerSecret(consumer_secret);
		                     cb.setOAuthAccessToken(token_access);
		                     cb.setOAuthAccessTokenSecret(token_secret);
		                     
	    TwitterStream stream =    new TwitterStreamFactory(cb.build()).getInstance();
	    
          
		StatusListener listener = new StatusListener() {
                 public void onStatus(Status status) {
                	 
		          tweetList.add(status.getText());
		         
					 
  		    		
		          ArrayList<String> tweets = tweetList;
		         
		          NLP.init();    
		          	    		
		          for(String tweet : tweets) {
         	               	        		
         		    	if(NLP.findSentiment(tweet)>2)	{ 
         		    		tw.add(tweet); 
         		    		
         		    		System.out.println(tweet);
         		    		
						 		
		          }
		          } 
		          
		        
		         
		          
		          
		    }

		                   public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		                       System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
		                   }

		                   public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		                       System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
		                   }

		                   public void onScrubGeo(long userId, long upToStatusId) {
		                       System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
		                   }

		                   public void onException(Exception ex) {
		                       ex.printStackTrace();
		                   }

		       			

		       			@Override
		       			public void onStallWarning(StallWarning warning) {
		       				// TODO Auto-generated method stub
		       				
		       			}
		               }; 
		   
		               FilterQuery qry = new FilterQuery();
		               String[] key1 = { "@ENITalktous" };
		               
		             

		               stream.addListener(listener);
		               qry.track(key1);
		               stream.filter(qry);
		               
		               
		               try {
		       			Thread.sleep(10000);
		       		} catch (InterruptedException e1) {
		       			
		       			e1.printStackTrace();
		       		}
		              
		               //out.println("<a href='signin.jsp'>visit</a>")
		              
   		    	/*	 request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		               final AsyncContext asyncContext = request.startAsync();
		               asyncContext.addListener(new AsyncListenerDemo());
		               asyncContext.setTimeout(5000);
		               asyncContext.start(new Runnable() {
		            	   
		                   @Override
		                   public void run() {
		                   	   // long-running task
		                       try {
		                  	HttpSession session=request.getSession(true);
		      		            session.setAttribute("lis",tw);
		      		          session.getAttribute("lis");   
		                       asyncContext.dispatch("/signin.jsp");
				            	//   request.setAttribute("lis", tw);
		                           Thread.sleep(3000);
		                       } catch (InterruptedException e) {
		                       }
		                    
		                   }
		               });*/
		               
		    		       
		           }	
		
	  
	    }
       

	

            
            
        
       
	

        
	


