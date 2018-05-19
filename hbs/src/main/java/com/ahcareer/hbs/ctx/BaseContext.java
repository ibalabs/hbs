package com.ahcareer.hbs.ctx;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ahcareer.hbs.persistance.base.CreatePersistentObject;
import com.ahcareer.hbs.persistance.base.CreateUpdatePersistentObject;

/**
 * 
 * BaseContext.java
 *
 */
public final class BaseContext extends HibernateDaoSupport {

  @Autowired(required = true)
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  /**
   * Constructor
   * 
   * @param sessionFactory
   */
  public BaseContext(SessionFactory sessionFactory) {
    this.setSessionFactory(sessionFactory);
  }

  /**
   * Save Or Update Data
   * 
   * @param object
   * @throws Exception
   */
  public <T extends CreateUpdatePersistentObject> void saveOrUpdate(T object)
      throws Exception {
    this.getSessionFactory().getCurrentSession().saveOrUpdate(object);
  }

  /**
   * Save Or Update All Objects Data
   * 
   * @param entities
   * @throws Exception
   */
  public <T extends CreateUpdatePersistentObject> void saveOrUpdateAll(
      List<T> entities) throws Exception {
    for (T entity : entities) {
      this.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }
  }

  /**
   * Save Or Update Data
   * 
   * @param object
   * @throws Exception
   */
  public <T extends CreatePersistentObject> void save(T object)
      throws Exception {
    this.getSessionFactory().getCurrentSession().save(object);
  }

  /**
   * Save Or Update All Objects Data
   * 
   * @param entities
   * @throws Exception
   */
  public <T extends CreatePersistentObject> void saveAll(List<T> entities)
      throws Exception {
    for (T entity : entities) {
      this.getSessionFactory().getCurrentSession().save(entity);
    }
  }

  /**
   * Delete Data
   * 
   * @param object
   * @throws Exception
   */
  public <T extends CreatePersistentObject> void delete(T object)
      throws Exception {
    this.getSessionFactory().getCurrentSession().delete(object);
  }

  /**
   * Delete All Objects Data
   * 
   * @param entities
   * @throws Exception
   */
  public <T extends CreatePersistentObject> void deleteAll(List<T> entities)
      throws Exception {
    for (T entity : entities) {
      this.getSessionFactory().getCurrentSession().delete(entity);
    }
  }

  /**
   * Fetch Objects Based On Search Options
   * 
   * @param clazz
   * @param options
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <T extends CreateUpdatePersistentObject> List<T> fetchObjects(
      Class<T> clazz, Options options) throws Exception {
    Criteria criteria = DetachedCriteria.forClass(clazz)
        .getExecutableCriteria(this.getSessionFactory().getCurrentSession());
    if (options != null) {
      if (options.startRecord != -1) {
        criteria.setFirstResult(options.startRecord);
      }
      if (options.numberOfRecords != -1) {
        criteria.setMaxResults(options.numberOfRecords);
      }

      // order by check
      if (!options.getOrderByList().isEmpty()) {
        for (OrderBy orderBy : options.getOrderByList()) {
          boolean isAscending = orderBy.isAscending();
          if (isAscending) {
            criteria.addOrder(Order.asc(orderBy.getColumnName()).ignoreCase());
          } else {
            criteria.addOrder(Order.desc(orderBy.getColumnName()).ignoreCase());
          }
        }
      }
      if (options.criterion != null) {
        criteria.add(options.criterion);
      }
    }
    return (List<T>) criteria.list();
  }

  /**
   * Fetch Objects Based On Search Options
   * 
   * @param clazz
   * @param options
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unchecked")
  public <T extends CreatePersistentObject> List<T> fetchCreateObjects(
      Class<T> clazz, Options options) throws Exception {
    Criteria criteria = DetachedCriteria.forClass(clazz)
        .getExecutableCriteria(this.getSessionFactory().getCurrentSession());
    if (options != null) {
      if (options.startRecord != -1) {
        criteria.setFirstResult(options.startRecord);
      }
      if (options.numberOfRecords != -1) {
        criteria.setMaxResults(options.numberOfRecords);
      }

      // order by check
      if (!options.getOrderByList().isEmpty()) {
        for (OrderBy orderBy : options.getOrderByList()) {
          boolean isAscending = orderBy.isAscending();
          if (isAscending) {
            criteria.addOrder(Order.asc(orderBy.getColumnName()).ignoreCase());
          } else {
            criteria.addOrder(Order.desc(orderBy.getColumnName()).ignoreCase());
          }
        }
      }
      if (options.criterion != null) {
        criteria.add(options.criterion);
      }
    }
    return (List<T>) criteria.list();
  }

}