package com.src.support;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
public class AsyncListenerDemo implements AsyncListener {
	private static Logger logger = Logger.getLogger("WhatToThink.java");
	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		logger.info("Inside onComplete method.");
	}
	@Override
	public void onError(AsyncEvent arg0) throws IOException {
		logger.severe("Inside onError method.");
	}
	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		logger.info("Inside onStartAsync method.");
	}
	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		logger.info("Inside onTimeout method.");
		
	}
}