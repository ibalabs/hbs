package com.ahcareer.hbs.session;

import java.io.Serializable;

import com.ahcareer.hbs.persistance.UserDetails;

/**
 * 
 * _Session.java
 *
 */
@SuppressWarnings("serial")
public class _Session implements Serializable {
  private String userName;
  private UserDetails userDetails;
  private String serverResultid;

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserDetails getUserDetails() {
    return this.userDetails;
  }

  public void setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
  }

  public String getServerResultid() {
    return this.serverResultid;
  }

  public void setServerResultid(String serverResultid) {
    this.serverResultid = serverResultid;
  }
}
