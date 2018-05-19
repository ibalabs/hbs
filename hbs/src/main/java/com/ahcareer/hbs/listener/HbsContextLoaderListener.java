package com.ahcareer.hbs.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * HbsContextLoaderListener.java
 *
 */
@WebListener
public class HbsContextLoaderListener implements ServletContextListener {

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.context.ContextLoaderListener#contextInitialized
   * (javax.servlet.ServletContextEvent)
   */
  public final void contextInitialized(ServletContextEvent event) {
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
   * ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
  }
}
