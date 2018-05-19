package com.ahcareer.hbs.enums;

import java.io.Serializable;

/**
 * 
 * ViewNameEnum.java
 *
 */
public enum ViewNameEnum implements Serializable {

  SHOW_REGISTRATION_VIEW("/registration"), SHOW_LOGIN_VIEW(
      "/login"), SHOW_DASHBOARD_VIEW("/dashboard"), SHOW_UOM_VIEW(
          "/uom"), SHOW_PRODUCTS_VIEW("/products"), SHOW_CUSTOMERS_VIEW(
              "/customers"), SHOW_SALES_INVOICE_VIEW(
                  "/sales_invoice"), SHOW_RECEIPTS_VIEW(
                      "/receipts"), SHOW_TOTALDUELIST_VIEW(
                          "/total_due_list"), SHOW_CUSTOMER_REPORTS_VIEW(
                              "/customer_reports"), SHOW_PRODUCT_REPORTS_VIEW(
                                  "/product_wise_reports"), SHOW_REFERRAL_REPORTS_VIEW(
                                      "/referral_wise_cost"), SHOW_PRODUCT_COST_REPORTS_VIEW(
                                          "/product_wise_cost");
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
