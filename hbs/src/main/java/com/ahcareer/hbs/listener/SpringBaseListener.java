package com.ahcareer.hbs.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

/**
 * SpringBaseListener.java
 *
 */
public class SpringBaseListener extends ContextLoaderListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.ContextLoaderListener#contextInitialized(
	 * javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		this.logger.info("Server initialized successfully");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.ContextLoaderListener#contextDestroyed(
	 * javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		this.logger.info("Server stopped successfully");
	}
}
