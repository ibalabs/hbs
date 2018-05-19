package com.ahcareer.hbs.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahcareer.hbs.dao.CamsDao;
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
  private CamsDao camsDao;

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

    this.camsDao.saveUserDetails(userDetails);

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
    List<UserDetails> userDetailsList = this.camsDao
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
}