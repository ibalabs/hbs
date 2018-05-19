package com.ahcareer.hbs.persistance.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * PersistentObject.java
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class CreateUpdatePersistentObject
    extends CreatePersistentObject {

  public static String C_UPDATEDBY = "updatedBy";
  public static String C_UPDATED = "updated";

  private String updatedBy;
  private long updated;

  /**
   * Getter For Updated By
   * 
   * @return
   */
  @Column(name = "updated_by", insertable = false, updatable = true, nullable = true, unique = false)
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Setter For Updated By
   * 
   * @param updatedBy
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * Getter For Updated
   * 
   * @return
   */
  @Column(name = "updated", insertable = false, updatable = true, nullable = true, unique = false)
  public long getUpdated() {
    return updated;
  }

  /**
   * Getter For Updated
   * 
   * @param updated
   */
  public void setUpdated(long updated) {
    this.updated = updated;
  }
}
