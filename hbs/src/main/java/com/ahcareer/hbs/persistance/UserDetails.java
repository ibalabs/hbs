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
@Table(name = "hbs_user_details")
public class UserDetails extends CreateUpdatePersistentObject {

  private String userName;
  private String firstName;
  private String lastName;
  private String password;

  /**
   * Getter For User Name
   * 
   * @return
   */
  @Column(name = "user_name", insertable = true, unique = true, nullable = false)
  public String getUserName() {
    return this.userName;
  }

  /**
   * Setter For User Name
   * 
   * @param userName
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Getter for First Name
   * 
   * @return
   */
  @Column(name = "first_name", insertable = true, updatable = true, nullable = true)
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Setter For First Name
   * 
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Getter for Last Name
   * 
   * @return
   */
  @Column(name = "last_name", insertable = true, updatable = true, nullable = true)
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Setter for Last Name
   * 
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Getter For Password
   * 
   * @return
   */
  @Column(name = "password", insertable = true, updatable = true, nullable = false)
  public String getPassword() {
    return this.password;
  }

  /**
   * Setter For Password
   * 
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UserDetails [userName=" + userName + ", firstName=" + firstName
        + ", lastName=" + lastName + ", password=" + password + "]";
  }

}
