/*package com.src.support;

import java.util.ArrayList;

import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterManager {
	 final static ArrayList<String> tweetList =  new ArrayList<String>();

    public static ArrayList<String> getTweets(String topic) {
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
                
               //ArrayList<String> tweets = tweetList;
                   ArrayList<String> tweets = tweetList;
    	        
                NLP.init();
    	        for(String tweet : tweets) {
    	        	if(NLP.findSentiment(tweet)>2)
    	        	{
    	              return  tweet;
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
      
		return tweetList;
    }
}*/