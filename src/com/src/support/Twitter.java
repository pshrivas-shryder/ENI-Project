/*package com.src.support;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
/*
import twitter4j.Query;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
*/

/**
 * Servlet implementation class Twitter
 */
/*
public class Twitter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();
		PrintWriter out = response.getWriter();
		
		cb.setOAuthConsumerKey("ESH4JNY49MZwqMnTE1TdTzjyk");
		cb.setOAuthConsumerSecret("SKWcYj9pI7f2InB9C8FC748s5zC2dqbZBzNZjjgQUD075BzZoC");
		cb.setOAuthAccessToken("4742496138-MKPDheW9BDIwlD8lR4AIHImiwGCUFlfjQ142023");
		cb.setOAuthAccessTokenSecret("I8G52hxkeUj5Y1LBSXUcuTP95Q8JtRKOB1FxJXc3PWGOz"); // Create Twitter instance
		
		twitter4j.Twitter twitter = new TwitterFactory(cb.build()).getInstance(); // Create file writer and buffer writer
		
		//FileWriter fstream = new FileWriter("Twitterstream.txt",true);
		Query query = new Query("");
		
		query.setQuery("#USAirways"); // Get query result
		
		try	{
			QueryResult qr = twitter.search(query); // Get tweets and write in the file
			while(qr.hasNext())	{
				qr.nextQuery();
				List<Status> tweets = qr.getTweets();
				for (Status t: tweets)	{
					out.print("ID of Tweet" + t.getId() + " - " + t.getCreatedAt() + "By User: " + t.getUser() + ": Tweet - " + t.getText());
				}
			}
		} catch (Exception e)	{
			throw new RuntimeException(e);
		}
		
		try	{
			Thread.sleep(1000*60*15);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	


