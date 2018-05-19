package com.ahcareer.hbs.svc;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahcareer.hbs.dao.CamsDao;
import com.google.gson.JsonParser;

/**
 * AbstractService.java
 *
 */
@Service("abstractService")
public abstract class AbstractService {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  protected final JsonParser jsonParser = new JsonParser();

  @Autowired(required = true)
  protected CamsDao camsDao;

  /**
   * Get Id
   * 
   * @return
   */
  public String getId() {
    return UUID.randomUUID().toString();
  }
}
