package com.ahcareer.hbs.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahcareer.hbs.ctx.Options;
import com.ahcareer.hbs.persistance.CustomerDetails;
import com.ahcareer.hbs.persistance.UomDetails;
import com.ahcareer.hbs.persistance.UserDetails;

/**
 * HbsDao.java
 *
 */
@SuppressWarnings("serial")
@Service(value = "userDao")
@Transactional
public class HbsDao extends BaseDao implements Serializable {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * Save User Details
   * 
   * @param userDetails
   * @throws Exception
   */
  public void saveUserDetails(UserDetails userDetails) throws Exception {
    this.logger.info("Saving user details to database..." + userDetails);
    userDetails.setId(this.getId());
    this.context.saveOrUpdate(userDetails);
  }

  /**
   * Fetch User By User Name
   * 
   * @param userName
   * @return
   * @throws Exception
   */
  public List<UserDetails> fetchUserByUserName(String userName)
      throws Exception {
    Options options = new Options();
    Criterion userNameCriterion = Restrictions.eq("userName", userName);
    options.setCriterion(userNameCriterion);

    List<UserDetails> userDetailsList = this.context
        .fetchObjects(UserDetails.class, options);

    return userDetailsList;
  }

  /**
   * Fetch All Uom Details
   * 
   * @return
   * @throws Exception
   */
  public List<UomDetails> fetchAllUomDetails() throws Exception {
    Options options = new Options();
    return this.context.fetchObjects(UomDetails.class, options);
  }

  /**
   * Save UOM Details
   * 
   * @param details
   * @throws Exception
   */
  public void saveUomDetails(UomDetails details) throws Exception {
    this.context.saveOrUpdate(details);
  }

  /**
   * Fetch UOM Details By ID
   * 
   * @param id
   * @return
   * @throws Exception
   */
  public UomDetails fetchUomDetalsById(String id) throws Exception {
    Options options = new Options();
    Criterion criterion = Restrictions.eq(UomDetails.C_ID, id);
    options.setCriterion(criterion);
    List<UomDetails> uomDetailsList = this.context
        .fetchObjects(UomDetails.class, options);

    if (uomDetailsList == null || uomDetailsList.isEmpty()) {
      throw new Exception("No Uom Details found to fetch");
    }

    return uomDetailsList.get(0);
  }

  /**
   * Fetch Uom Details by UOM Name
   * 
   * @param uomId
   * @param uomName
   * @return
   * @throws Exception
   */
  public List<UomDetails> fetchAllUomDetailsByUomId(String uomId)
      throws Exception {
    Options options = new Options();
    Criterion uomIdCriterion = Restrictions.eq(UomDetails.UOM_ID, uomId);
    options.setCriterion(uomIdCriterion);
    return this.context.fetchObjects(UomDetails.class, options);
  }

  /**
   * Fetch Uom Details By UOM Name
   * 
   * @param uomName
   * @return
   * @throws Exception
   */
  public List<UomDetails> fetchAllUomDetailsByUomName(String uomName)
      throws Exception {
    Options options = new Options();
    Criterion uomIdCriterion = Restrictions.eq(UomDetails.UOM_NAME, uomName);
    options.setCriterion(uomIdCriterion);
    return this.context.fetchObjects(UomDetails.class, options);
  }

  /**
   * Fetch Customer Details By Customer Name
   * 
   * @param custName
   * @return
   * @throws Exception
   */
  public List<CustomerDetails> fetchAllCustomerDetailsByName(String custName)
      throws Exception {
    Options options = new Options();
    Criterion custNameCriterion = Restrictions
        .eq(CustomerDetails.C_CUSTOMER_NAME, custName);
    options.setCriterion(custNameCriterion);
    return this.context.fetchObjects(CustomerDetails.class, options);
  }

  /**
   * fetch Customer Details By Id
   * 
   * @param dbId
   * @return
   * @throws Exception
   */
  public CustomerDetails fetchCustomerDetailsById(String dbId)
      throws Exception {
    Options options = new Options();
    Criterion idCriterion = Restrictions.eq(CustomerDetails.C_ID, dbId);
    options.setCriterion(idCriterion);
    List<CustomerDetails> customerDetailsList = this.context
        .fetchObjects(CustomerDetails.class, options);
    if (customerDetailsList == null || customerDetailsList.isEmpty()) {
      throw new Exception("No Details found to update or fetch");
    }
    return customerDetailsList.get(0);
  }

  /**
   * Save Customer Details
   * 
   * @param details
   * @throws Exception
   */
  public void saveCustomerDetails(CustomerDetails details) throws Exception {
    this.context.saveOrUpdate(details);
  }

  /**
   * Fetch All Customer Details
   * 
   * @return
   * 
   * @throws Exception
   */
  public List<CustomerDetails> fecthAllCustomerDetails() throws Exception {
    Options options = new Options();
    return this.context.fetchCreateObjects(CustomerDetails.class, options);
  }

  /**
   * Delete Customer Details
   * 
   * @param dbId
   * @throws Exception
   */
  public void deteleCustomerDetailsById(String dbId) throws Exception {
    CustomerDetails customerDetails = this.fetchCustomerDetailsById(dbId);
    this.context.delete(customerDetails);
  }
}