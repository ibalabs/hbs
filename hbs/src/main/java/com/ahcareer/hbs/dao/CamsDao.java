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
import com.ahcareer.hbs.persistance.UserDetails;

/**
 * CamsDao.java
 *
 */
@SuppressWarnings("serial")
@Service(value = "userDao")
@Transactional
public class CamsDao extends BaseDao implements Serializable {
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
}