package com.ahcareer.hbs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ahcareer.hbs.enums.ViewNameEnum;
import com.ahcareer.hbs.persistance.UserDetails;
import com.ahcareer.hbs.reqres.HbsRequest;
import com.ahcareer.hbs.reqres.HbsResponse;
import com.ahcareer.hbs.svc.HbsService;
import com.ahcareer.hbs.util.Constants;
import com.ahcareer.hbs.util.JSONUtils;
import com.ahcareer.hbs.util.StatusKeys;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * HbsController.java
 *
 */
@Controller
public class HbsController extends AbstractController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private JsonParser jsonParser = new JsonParser();
  protected Gson gson = new Gson();

  @Autowired(required = true)
  private HbsService hbsService;

  /**
   * Ping
   * 
   * @return
   */
  @RequestMapping(value = Constants.PING, method = RequestMethod.GET)
  public @ResponseBody String ping() {
    return StatusKeys.ALIVE + " - " + System.currentTimeMillis();
  }

  /**
   * Login
   * 
   * @return
   */
  @RequestMapping(value = { Constants.LOGIN, "/" }, method = RequestMethod.GET)
  public ModelAndView login() {
    this.logger.info("INSIDE LOGIN.....");
    return new ModelAndView(ViewNameEnum.SHOW_LOGIN_VIEW.getViewName());
  }

  /**
   * Check User
   * 
   * @param body
   * @return
   */
  @RequestMapping(value = Constants.CREATE_USER, method = RequestMethod.POST)
  public @ResponseBody String createUser(@RequestBody String jsonString) {
    HbsResponse baseResponse = new HbsResponse();

    try {
      JsonObject jsonObject = (JsonObject) this.jsonParser.parse(jsonString);
      this.logger.info("jsonObject..." + jsonObject);

      this.hbsService.createUser(this.getRequest(jsonString));
      baseResponse.setStatus(StatusKeys.SUCCESS);
      baseResponse.setMessage("User saved successfully");

    } catch (Exception e) {
      e.printStackTrace();
      String message = "Error while saving user details";
      if (e.getCause() != null) {
        message = e.getMessage();
      }
      baseResponse.setStatus(StatusKeys.ERROR);
      baseResponse.setMessage(message);
    }
    return JSONUtils.toJson(baseResponse);
  }

  /**
   * User Login
   * 
   * @return
   */
  @RequestMapping(value = Constants.USER_LOGIN, method = RequestMethod.POST)
  public String userLogin(HttpServletRequest httpServletRequest) {
    HbsResponse hbsResponse = new HbsResponse();
    String userName = httpServletRequest
        .getParameter(Constants.LOGIN_USER_NAME);
    Map<String, Object> modelMap = new HashMap<>();
    try {
      String password = httpServletRequest
          .getParameter(Constants.LOGIN_PASSWORD);

      JsonObject jsonObject = new JsonObject();
      jsonObject.addProperty(Constants.USER_NAME, userName);
      jsonObject.addProperty(Constants.PASSWORD, password);

      HbsRequest hbsRequest = new HbsRequest();
      hbsRequest.setRequestData(jsonObject);

      UserDetails details = this.hbsService.userLogin(hbsRequest);
      this.buildUserSession(details);
      modelMap.put(Constants.LOGGED_USER_INFO, details);
      this.logger.info("User logged-in successfully " + userName);
      return this.redirect(Constants.SHOW_DASHBOARD_VIEW);
    } catch (Exception e) {
      e.printStackTrace();
      String message = "Error while user login for " + userName;
      if (e.getCause() == null) {
        message = e.getMessage();
      }
      hbsResponse.setStatus(StatusKeys.ERROR);
      hbsResponse.setMessage(message);
      this.logger.error(message);
      return this.redirect(Constants.LOGIN);
    }
  }

  /**
   * Show DashBoard
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_DASHBOARD_VIEW, method = RequestMethod.GET)
  public ModelAndView showDashboard(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW DASHBOARD.....");
    return new ModelAndView(ViewNameEnum.SHOW_DASHBOARD_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show UOM
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_UOM_VIEW, method = RequestMethod.GET)
  public ModelAndView showUom(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_UOM_VIEW.....");
    return new ModelAndView(ViewNameEnum.SHOW_UOM_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show Products
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_PRODUCTS_VIEW, method = RequestMethod.GET)
  public ModelAndView showProducts(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_PRODUCTS_VIEW.....");
    return new ModelAndView(ViewNameEnum.SHOW_PRODUCTS_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show Customers
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_CUSTOMERS_VIEW, method = RequestMethod.GET)
  public ModelAndView showCustomers(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_PRODUCTS_VIEW.....");
    return new ModelAndView(ViewNameEnum.SHOW_CUSTOMERS_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show Sales Invoice
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_SALES_INVOICE_VIEW, method = RequestMethod.GET)
  public ModelAndView showSalesInvoice(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_SALES_INVOICE_VIEW.....");
    return new ModelAndView(ViewNameEnum.SHOW_SALES_INVOICE_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show Receipts
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_RECEIPTS_VIEW, method = RequestMethod.GET)
  public ModelAndView showReceipts(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_SALES_INVOICE_VIEW.....");
    return new ModelAndView(ViewNameEnum.SHOW_RECEIPTS_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show Total Due List
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_TOTAL_DUE_LIST_VIEW, method = RequestMethod.GET)
  public ModelAndView showTotalDueList(HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_TOTAL_DUE_LIST_VIEW.....");
    return new ModelAndView(ViewNameEnum.SHOW_TOTALDUELIST_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * Show Customer Reports
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_CUSTOMER_REPORTS_VIEW, method = RequestMethod.GET)
  public ModelAndView showCustomerReports(
      HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_CUSTOMER_REPORTS_VIEW.....");
    return new ModelAndView(
        ViewNameEnum.SHOW_CUSTOMER_REPORTS_VIEW.getViewName(), new HashMap<>());
  }

  /**
   * Show Product Reports
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_PRODUCT_REPORTS_VIEW, method = RequestMethod.GET)
  public ModelAndView showProductReports(
      HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_PRODUCT_REPORTS_VIEW.....");
    return new ModelAndView(
        ViewNameEnum.SHOW_PRODUCT_REPORTS_VIEW.getViewName(), new HashMap<>());
  }

  /**
   * Show Referral Reports
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_REFERRAL_REPORTS_VIEW, method = RequestMethod.GET)
  public ModelAndView showReferralReports(
      HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_REFERRAL_REPORTS_VIEW.....");
    return new ModelAndView(
        ViewNameEnum.SHOW_REFERRAL_REPORTS_VIEW.getViewName(), new HashMap<>());
  }

  /**
   * Show Product Cost Reports
   * 
   * @return
   */
  @RequestMapping(value = Constants.SHOW_PRODUCT_COST_REPORTS_VIEW, method = RequestMethod.GET)
  public ModelAndView showProductCostReports(
      HttpServletRequest httpServletRequest) {
    this.logger.info("INSIDE SHOW SHOW_PRODUCT_COST_REPORTS_VIEW.....");
    return new ModelAndView(
        ViewNameEnum.SHOW_PRODUCT_COST_REPORTS_VIEW.getViewName(),
        new HashMap<>());
  }

  /**
   * init
   */
  @PostConstruct
  public void init() {
    try {
      this.logger.info("THIS IS INSIDE INIT..");
    } catch (Exception e) {
      this.logger.error("ERROR WHILE GETTEING THE CONNECTION....", e);
    }
  }
}
