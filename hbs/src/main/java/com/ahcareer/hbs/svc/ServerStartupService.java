package com.ahcareer.hbs.svc;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * ServerStartupService.java
 *
 */
@Service("serverStartUpService")
public class ServerStartupService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * Initialize.
   * 
   * @param props
   * 
   * @throws Exception
   */
  public void initialize(Properties props) throws Exception {
    this.logger.info("THIS IS INSIDE SERVER STARTUP SERVICE..." + props);
  }
}