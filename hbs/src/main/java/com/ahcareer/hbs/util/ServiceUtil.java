package com.ahcareer.hbs.util;

import org.springframework.context.ApplicationContext;

/**
 * 
 * ServiceUtil.java
 *
 */
public class ServiceUtil {

  private static ServiceUtil serviceUtil = new ServiceUtil();
  private ApplicationContext appContext = null;

  /**
   * Private Constructor to make this as Singleton
   */

  private ServiceUtil() {

  }

  /**
   * Reference for the singleton object
   */
  public static synchronized ServiceUtil getInstance() {
    return serviceUtil;
  }

  /**
   * Getter for ApplicationContext
   */
  public ApplicationContext getApplicationContext() {
    return this.appContext;
  }

  /**
   * Build the Application Context that will be used for look up of the beans
   * later
   */
  public synchronized void buildAppContext(ApplicationContext servContext) {
    this.appContext = servContext;
  }

  /**
   * Get the bean implementation based on the bean name passed
   */
  public synchronized Object getBean(String beanId) {
    return this.appContext.getBean(beanId);
  }

  /**
   * Get the bean implementation based on the bean class passed
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public synchronized Object getBean(Class beanClass) {
    return this.appContext.getBean(beanClass);
  }
}
