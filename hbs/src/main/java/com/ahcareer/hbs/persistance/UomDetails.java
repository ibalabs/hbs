package com.ahcareer.hbs.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ahcareer.hbs.persistance.base.CreateUpdatePersistentObject;

/**
 * UserDetails.java
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hbs_unit_of_measure")
public class UomDetails extends CreateUpdatePersistentObject {

  public static String UOM_ID = "uomId";
  public static String UOM_NAME = "uomName";
  public static String UOM_DESC = "uomDesc";

  private String uomId;
  private String uomName;
  private String uomDesc;

  /**
   * @return the uomId
   */
  @Column(name = "uom_id")
  public String getUomId() {
    return uomId;
  }

  /**
   * @param uomId
   *          the uomId to set
   */
  public void setUomId(String uomId) {
    this.uomId = uomId;
  }

  /**
   * @return the uomName
   */
  @Column(name = "uom_name")
  public String getUomName() {
    return uomName;
  }

  /**
   * @param uomName
   *          the uomName to set
   */
  public void setUomName(String uomName) {
    this.uomName = uomName;
  }

  /**
   * @return the uomDesc
   */
  @Column(name = "uom_desc")
  public String getUomDesc() {
    return uomDesc;
  }

  /**
   * @param uomDesc
   *          the uomDesc to set
   */
  public void setUomDesc(String uomDesc) {
    this.uomDesc = uomDesc;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UomDetails [uomId=" + uomId + ", uomName=" + uomName + ", uomDesc="
        + uomDesc + "]";
  }

  /*
   * F(non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    UomDetails details = (UomDetails) obj;
    boolean result = details.getId().equals(this.id);
    return result;
  }
}
