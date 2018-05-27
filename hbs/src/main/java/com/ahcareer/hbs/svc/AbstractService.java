package com.ahcareer.hbs.svc;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahcareer.hbs.dao.HbsDao;
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
  protected HbsDao hbsDao;

  /**
   * Get Id
   * 
   * @return
   */
  public String getId() {
    return UUID.randomUUID().toString();
  }

  /**
   * Validate Customer Details
   * 
   * @param custDesc
   * @param custName
   * @param address
   * @param mobile
   * @param city
   * @param alias
   * @param balAmt
   */
  protected void validateCustomerDetails(String custDesc, String custName,
      String address, String mobile, String city, String alias, String balAmt)
      throws Exception {

    if (custName == null || custName.isEmpty()) {
      throw new Exception("Please enter Customer Name");
    }

    if (alias == null || alias.isEmpty()) {
      throw new Exception("Please enter Alias");
    }

    if (address == null || address.isEmpty()) {
      throw new Exception("Please enter Address");
    }

    if (city == null || city.isEmpty()) {
      throw new Exception("Please enter City");
    }

    if (mobile == null || mobile.isEmpty()) {
      throw new Exception("Please enter Mobile Number");
    }

    if (balAmt == null || balAmt.isEmpty()) {
      throw new Exception("Please enter Balance Amount");
    }
  }
}
