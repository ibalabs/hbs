package com.ahcareer.hbs.ctx;

/**
 * OrderBy.java
 * 
 * Author : MANPAR TECHNOLOGIES
 */
public class OrderBy {
  private String columnName;
  private boolean ascending;
  private int columnIndex = 1;

  public OrderBy(String columnName, boolean ascending) {
    this.columnName = columnName;
    this.ascending = ascending;
  }

  public OrderBy(int columnIndex, boolean ascending) {
    this.columnIndex = columnIndex;
    this.columnName = null;
    this.ascending = ascending;
  }

  public String getColumnName() {
    return columnName;
  }

  public boolean isAscending() {
    return ascending;
  }

  public int getColumnIndex() {
    return columnIndex;
  }

  public void setColumnIndex(int columnIndex) {
    this.columnIndex = columnIndex;
  }

  public String getOrderByString() {
    String sortDir = this.ascending ? "ASC" : "DESC";
    return this.columnName == null || this.columnName.trim().isEmpty()
        ? String.valueOf(this.columnIndex) + " " + sortDir
        : this.columnName + " " + sortDir;
  }
}
