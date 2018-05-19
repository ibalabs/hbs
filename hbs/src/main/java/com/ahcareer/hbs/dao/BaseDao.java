package com.ahcareer.hbs.dao;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ahcareer.hbs.ctx.BaseContext;

/**
 * BaseDao.java
 *
 */
public abstract class BaseDao {

  private final static Logger logger = LoggerFactory.getLogger(BaseDao.class);

  protected BaseContext context;

  @Autowired(required = true)
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  /**
   * Post Construct method
   */
  @PostConstruct
  public final void initialize() {
    this.context = new BaseContext(this.sessionFactory);
    logger.info(
        "After initializing the BaseDao and creation of Context successful");
    try {
    } catch (Exception cex) {
      throw new RuntimeException(cex);
    }
  }

  /**
   * and
   * 
   * @param criterions
   * @return
   */
  protected Criterion and(Criterion... criterions) {
    if (criterions == null || criterions.length <= 0) {
      return null;
    }
    Criterion returnCriterion = null;
    for (Criterion criterion : criterions) {
      if (criterion == null) {
        continue;
      }
      if (returnCriterion == null) {
        returnCriterion = criterion;
        continue;
      }
      returnCriterion = Restrictions.and(returnCriterion, criterion);
    }
    return returnCriterion;
  }

  /**
   * or
   * 
   * @param criterions
   * @return
   */
  protected Criterion or(Criterion... criterions) {
    if (criterions == null || criterions.length <= 0) {
      return null;
    }
    Criterion returnCriterion = null;
    for (Criterion criterion : criterions) {
      if (criterion == null) {
        continue;
      }
      if (returnCriterion == null) {
        returnCriterion = criterion;
        continue;
      }
      returnCriterion = Restrictions.or(returnCriterion, criterion);
    }
    return returnCriterion;
  }

  /**
   * Get Id
   * 
   * @return
   */
  public String getId() {
    return UUID.randomUUID().toString();
  }
}
