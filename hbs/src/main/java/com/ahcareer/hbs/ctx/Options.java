package com.ahcareer.hbs.ctx;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;

/**
 * Options.java
 *
 */
public class Options {

  public int startRecord = -1;
  public int numberOfRecords = -1;
  public boolean ignoreCase;
  public Criterion criterion;
  public Projection projection;
  private List<OrderBy> orderByList = new ArrayList<OrderBy>();

  /**
   * Default Constructor
   */
  public Options() {
  }

  /**
   * Options
   * 
   * @param startRecord
   * @param numberOfRecords
   */
  public Options(int startRecord, int numberOfRecords) {
    this.startRecord = startRecord;
    this.numberOfRecords = numberOfRecords;
  }

  public int getStartRecord() {
    return this.startRecord;
  }

  public int getNumberOfRecords() {
    return this.numberOfRecords;
  }

  public boolean isIgnoreCase() {
    return this.ignoreCase;
  }

  public Criterion getCriterion() {
    return this.criterion;
  }

  public void setStartRecord(int startRecord) {
    this.startRecord = startRecord;
  }

  public void setNumberOfRecords(int numberOfRecords) {
    this.numberOfRecords = numberOfRecords;
  }

  public void setIgnoreCase(boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }

  public void setCriterion(Criterion criterion) {
    this.criterion = criterion;
  }

  public List<OrderBy> getOrderByList() {
    return orderByList;
  }

  public void addOrderBy(OrderBy orderBy) {
    this.orderByList.add(orderBy);
  }

  public Projection getProjection() {
    return this.projection;
  }

  public void setProjection(Projection projection) {
    this.projection = projection;
  }
}
