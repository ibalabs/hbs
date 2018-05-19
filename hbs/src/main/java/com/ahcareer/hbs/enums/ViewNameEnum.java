package com.ahcareer.hbs.enums;

import java.io.Serializable;

/**
 * 
 * ViewNameEnum.java
 *
 */
public enum ViewNameEnum implements Serializable {

  SHOW_REGISTRATION_VIEW("/registration"), SHOW_LOGIN_VIEW(
      "/login"), SHOW_DASHBOARD_VIEW("/dashboard"), SHOW_APPLICATIONS_VIEW(
          "/applications"), SHOW_CONNECTORS_VIEW(
              "/connectors"), SHOW_MAILS_VIEW(
                  "/mails"), SHOW_CONFIGURATION_VIEW(
                      "/configuration"), SHOW_EDIT_APPLICATION_VIEW(
                          "/edit_application"), SHOW_NEW_APPLICATION_VIEW(
                              "/create_application"), SHOW_ALL_SPARC_TICKETS_VIEW(
                                  "/spark_tickets_details"), SHOW_SCHEDULES_VIEW(
                                      "/schedulers"), SHOW_AUDIT_VIEW(
                                          "/audit"), SHOW_MAIL_TOKENS_VIEW(
                                              "/mail_tokens"), SHOW_SYSTEM_CONFIGUARTION_VIEW(
                                                  "/system_configaruion");

  private String view;

  /**
   * Constructor.
   * 
   * @param view
   */
  ViewNameEnum(String view) {
    this.view = view;
  }

  /**
   * Get the associated View Name
   * 
   * @return
   */
  public String getViewName() {
    return this.view;
  }

}
