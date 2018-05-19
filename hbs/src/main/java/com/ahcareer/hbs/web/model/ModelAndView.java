package com.ahcareer.hbs.web.model;

import java.util.Map;

import com.ahcareer.hbs.enums.ModelKeyEnum;
import com.ahcareer.hbs.enums.ViewNameEnum;

/**
 * 
 * ModelAndView.java
 *
 */
public class ModelAndView {

  private ViewNameEnum view;
  private Map<ModelKeyEnum, Object> model;

  private boolean isRedirect = false;
  private String redirectUrl;

  /**
   * Constructor.
   * 
   * @param view
   * @param model
   */
  public ModelAndView(ViewNameEnum view, Map<ModelKeyEnum, Object> model) {
    this.view = view;
    this.model = model;
  }

  /**
   * Constructor
   * 
   * @param view
   * @param isRedirect
   */
  public ModelAndView(String redirectUrl) {
    this.redirectUrl = redirectUrl;
    this.isRedirect = true;
  }

  /**
   * Getter for view
   */
  public ViewNameEnum getView() {
    return view;
  }

  /**
   * Getter for model
   */
  public Map<ModelKeyEnum, Object> getModel() {
    return model;
  }

  /**
   * Getter for isRedirect
   */
  public boolean isRedirect() {
    return isRedirect;
  }

  /**
   * Getter for redirectUrl
   */
  public String getRedirectUrl() {
    return redirectUrl;
  }
}
