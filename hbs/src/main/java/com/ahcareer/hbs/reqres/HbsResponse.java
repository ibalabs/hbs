package com.ahcareer.hbs.reqres;

import com.ahcareer.hbs.util.StatusKeys;

/**
 * SpringBaseResponse.java
 *
 */
public class HbsResponse {
  private StatusKeys status;
  private String message;
  private Object data;

  /**
   * Getter For Status
   * 
   * @return
   */
  public StatusKeys getStatus() {
    return this.status;
  }

  /**
   * Setter For Status
   * 
   * @param status
   */
  public void setStatus(StatusKeys status) {
    this.status = status;
  }

  /**
   * Getter For Message
   * 
   * @return
   */

  public String getMessage() {
    return this.message;
  }

  /**
   * Setter For Message
   * 
   * @param message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}
