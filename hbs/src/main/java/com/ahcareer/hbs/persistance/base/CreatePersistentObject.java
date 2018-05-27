package com.ahcareer.hbs.persistance.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * PersistentObject.java
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class CreatePersistentObject implements Serializable {

  public static String C_ID = "id";
  public static String C_CREATEDBY = "createdBy";
  public static String C_CREATED = "created";

  protected String id;
  private String createdBy;
  private long created;

  /**
   * Getter For ID
   * 
   * @return
   */
  @Id
  @Column(name = "id")
  public String getId() {
    return id;
  }

  /**
   * Setter For ID
   * 
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Getter For Created By
   * 
   * @return
   */
  @Column(name = "created_by", insertable = true, updatable = false, nullable = false, unique = false)
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Setter For Created By
   * 
   * @param createdBy
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Getter For Created
   * 
   * @return
   */
  @Column(name = "created", insertable = true, updatable = false, nullable = false, unique = false)
  public long getCreated() {
    return created;
  }

  /**
   * Setter For Created
   * 
   * @param created
   */
  public void setCreated(long created) {
    this.created = created;
  }
}
