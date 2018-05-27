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
@Table(name = "hbs_customer_master")
public class CustomerDetails extends CreateUpdatePersistentObject {

  public static String C_CUSTOMER_NAME = "customerName";
  public static String C_ALIAS = "alias";
  public static String C_ADDRESS = "address";
  public static String C_CITY = "city";
  public static String C_MOBILE = "mobile";
  public static String C_BALNCE_AMOUNT = "balanceAmount";
  public static String C_DESCRIPTION = "desciption";

  private String customerName;
  private String alias;
  private String address;
  private String city;
  private String mobile;
  private String balanceAmount;
  private String desciption;

  /**
   * @return the customerName
   */
  @Column(name = "customer_name")
  public String getCustomerName() {
    return customerName;
  }

  /**
   * @param customerName
   *          the customerName to set
   */
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  /**
   * @return the alias
   */
  @Column(name = "alias")
  public String getAlias() {
    return alias;
  }

  /**
   * @param alias
   *          the alias to set
   */
  public void setAlias(String alias) {
    this.alias = alias;
  }

  /**
   * @return the address
   */
  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  /**
   * @param address
   *          the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the city
   */
  @Column(name = "city")
  public String getCity() {
    return city;
  }

  /**
   * @param city
   *          the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the mobile
   */
  @Column(name = "mobile")
  public String getMobile() {
    return mobile;
  }

  /**
   * @param mobile
   *          the mobile to set
   */
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  /**
   * @return the balanceAmount
   */
  @Column(name = "balance_amount")
  public String getBalanceAmount() {
    return balanceAmount;
  }

  /**
   * @param balanceAmount
   *          the balanceAmount to set
   */
  public void setBalanceAmount(String balanceAmount) {
    this.balanceAmount = balanceAmount;
  }

  /**
   * @return the desciption
   */
  @Column(name = "desrciption")
  public String getDesciption() {
    return desciption;
  }

  /**
   * @param desciption
   *          the desciption to set
   */
  public void setDesciption(String desciption) {
    this.desciption = desciption;
  }

}
