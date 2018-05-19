package com.ahcareer.hbs.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ahcareer.hbs.persistance.UserDetails;
import com.ahcareer.hbs.reqres.HbsRequest;
import com.ahcareer.hbs.session._Session;
import com.ahcareer.hbs.util.Constants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * AbstractController.java
 *
 */
public abstract class AbstractController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private JsonParser jsonParser = new JsonParser(); 

  /**
   * Get Request Object
   * 
   * @param jsonData
   * @return
   */
  public HbsRequest getRequest(String jsonData) {
    HbsRequest springBaseRequest = new HbsRequest();
    JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonData);
    this.logger.info("Converted JSON Object,.." + jsonObject);
    springBaseRequest.setRequestData(jsonObject);
    return springBaseRequest;
  }

  /**
   * Redirect to the mapping sent
   * 
   * @param mapping
   * @return
   */
  protected final String redirect(String mapping) {
    if (mapping.indexOf("/") == 0) {
      return new StringBuffer("redirect:").append(mapping).toString();
    } else {
      return new StringBuffer("redirect:/").append(mapping).toString();
    }
  }

  /**
   * Build User Session
   * 
   * @param userDetails
   * @throws Exception
   */
  public void buildUserSession(UserDetails userDetails) throws Exception {
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes();
    HttpSession httpSession = servletRequestAttributes.getRequest()
        .getSession();

    _Session session = (_Session) httpSession
        .getAttribute(Constants.SESSION_OBJECT);

    if (session == null) {
      session = new _Session();
    }
    session.setUserName(userDetails.getUserName());
    session.setUserDetails(userDetails);
    httpSession.setAttribute(Constants.SESSION_OBJECT, session);
  }

  /**
   * Get Logged In User Name
   * 
   * @return
   * @throws Exception
   */
  public String getLoggedInUserName() throws Exception {
    _Session session = this.getSession();
    if (session == null || session.getUserName() == null
        || session.getUserName().isEmpty()) {
      return Constants.ADMIN;
    }
    return session.getUserName().toUpperCase();
  }

  /**
   * Clear Session
   * 
   * @throws Exception
   */
  public void clearSession() throws Exception {
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes();
    HttpSession httpSession = servletRequestAttributes.getRequest()
        .getSession();

    _Session session = (_Session) httpSession
        .getAttribute(Constants.SESSION_OBJECT);

    if (session == null) {
      session = new _Session();
    }
    httpSession.setAttribute(Constants.SESSION_OBJECT, session);
  }

  /**
   * Get Session
   * 
   * @return
   * @throws Exception
   */
  public _Session getSession() throws Exception {
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes();
    HttpSession httpSession = servletRequestAttributes.getRequest()
        .getSession();

    _Session session = (_Session) httpSession
        .getAttribute(Constants.SESSION_OBJECT);

    if (session == null) {
      session = new _Session();
    }

    return session;
  }
}
