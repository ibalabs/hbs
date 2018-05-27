package com.ahcareer.hbs.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahcareer.hbs.dao.HbsDao;
import com.ahcareer.hbs.persistance.UomDetails;
import com.ahcareer.hbs.persistance.UserDetails;
import com.ahcareer.hbs.reqres.HbsRequest;
import com.ahcareer.hbs.util.Constants;
import com.google.gson.JsonObject;

/**
 * 
 * HbsService.java
 *
 */
@Service(value = "camsService")
public class HbsService extends AbstractService {

  @Autowired(required = true)
  private HbsDao hbsDao;

  /**
   * 
   * @param request
   */
  public void createUser(HbsRequest request) throws Exception {
    UserDetails userDetails = new UserDetails();
    JsonObject jsonObject = (JsonObject) request.getRequestData();

    String userName = jsonObject.get(Constants.USER_NAME).getAsString();
    String firstName = jsonObject.get(Constants.FIRST_NAME).getAsString();
    String lastName = jsonObject.get(Constants.LAST_NAME).getAsString();
    String password = jsonObject.get(Constants.PASSWORD).getAsString();

    userDetails.setFirstName(firstName);
    userDetails.setLastName(lastName);
    userDetails.setUserName(userName);
    userDetails.setPassword(password);
    userDetails.setCreatedBy(Constants.ADMIN);
    userDetails.setCreated(System.currentTimeMillis());

    this.hbsDao.saveUserDetails(userDetails);

  }

  /**
   * User Login
   * 
   * @param request
   * @return
   * @throws Exception
   */
  public UserDetails userLogin(HbsRequest request) throws Exception {
    JsonObject jsonObject = (JsonObject) request.getRequestData();

    String userName = jsonObject.get(Constants.USER_NAME).getAsString();
    String password = jsonObject.get(Constants.PASSWORD).getAsString();

    this.logger.info("userName,..." + userName + "..password,..." + password);
    List<UserDetails> userDetailsList = this.hbsDao
        .fetchUserByUserName(userName);

    this.logger.info("userDetailsList,..." + userDetailsList);

    if (userDetailsList == null || userDetailsList.isEmpty()) {
      throw new Exception("No user found with " + userName);
    }

    UserDetails details = userDetailsList.get(0);

    this.logger.info("details.." + details);

    String passwordFromDb = details.getPassword();

    if (!password.equals(passwordFromDb)) {
      throw new Exception("Username and password not matched");
    }
    return details;
  }

  /**
   * Save UOM
   * 
   * @param request
   * @throws Exception
   */
  public void saveUom(HbsRequest request) throws Exception {
    JsonObject jsonObject = (JsonObject) request.getRequestData();
    this.logger.info("jsonObject..." + jsonObject);
    String uomName = jsonObject.get(Constants.UOM_NAME).getAsString();
    String uomId = jsonObject.get(Constants.UOM_ID).getAsString();
    String uomDesc = jsonObject.get(Constants.UOM_DESC).getAsString();
    String action = jsonObject.get(Constants.ACTION).getAsString();
    String dbId = jsonObject.get(Constants.ID_UOM_DB_ID).getAsString();

    this.logger.info("action..." + action + "..dbId..." + dbId);

    if (uomId == null || uomId.isEmpty()) {
      throw new Exception("Please enter UOM ID");
    }

    if (uomName == null || uomName.isEmpty()) {
      throw new Exception("Please enter UOM Name");
    }

    if (uomDesc == null || uomDesc.isEmpty()) {
      throw new Exception("Please enter UOM Description");
    }

    List<UomDetails> uomDetailsList = this.hbsDao
        .fetchAllUomDetailsByUomId(uomId);

    this.logger.info("uomDetailsList...." + uomDetailsList);
    UomDetails details = new UomDetails();
    if (action.equalsIgnoreCase(Constants.CREATE)) {
      if (uomDetailsList != null && !uomDetailsList.isEmpty()) {
        throw new Exception("Details already exits with UOM ID " + uomId);
      }

      uomDetailsList = this.hbsDao.fetchAllUomDetailsByUomName(uomName);
      if (uomDetailsList != null && !uomDetailsList.isEmpty()) {
        throw new Exception("Details already exits with UOM Name " + uomName);
      }

      details.setId(this.getId());
      details.setUomId(uomId);
      details.setUomName(uomName);
      details.setUomDesc(uomDesc);
      details.setCreated(System.currentTimeMillis());
      details.setCreatedBy(Constants.ADMIN);
    } else {
      details = this.hbsDao.fetchUomDetalsById(dbId);
      if (!uomId.equalsIgnoreCase(details.getUomId())) {
        if (uomDetailsList != null && !uomDetailsList.isEmpty()) {
          throw new Exception("Details already exits with UOM ID " + uomId);
        }
      }
      if (!uomName.equalsIgnoreCase(details.getUomName())) {
        uomDetailsList = this.hbsDao.fetchAllUomDetailsByUomName(uomName);
        if (uomDetailsList != null && !uomDetailsList.isEmpty()) {
          throw new Exception("Details already exits with UOM Name " + uomName);
        }
      }
      details.setUomId(uomId);
      details.setUomName(uomName);
      details.setUomDesc(uomDesc);
      details.setUpdated(System.currentTimeMillis());
      details.setUpdatedBy(Constants.ADMIN);
    }

    this.logger.info("AFTER UPDATE..." + details);
    this.hbsDao.saveUomDetails(details);
  }

  /**
   * Fetch All UOM Details
   * 
   * @return
   * @throws Exception
   */
  public List<UomDetails> fetchAllUomDetails() throws Exception {
    return this.hbsDao.fetchAllUomDetails();
  }

  /**
   * Fetch UOM Details By Id
   * 
   * @param hbsRequest
   * @return
   */
  public UomDetails fetchAllUomDetailsById(HbsRequest hbsRequest)
      throws Exception {
    JsonObject jsonObject = (JsonObject) hbsRequest.getRequestData();
    String id = jsonObject.get(Constants.UOM_ID).getAsString();
    return this.hbsDao.fetchUomDetalsById(id);
  }
}