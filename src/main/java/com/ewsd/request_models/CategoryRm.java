package com.ewsd.request_models;

import java.io.Serializable;

public class CategoryRm implements Serializable {
	private Long id;	
	private String name;
	private Long deptId;
	private String deptName;
	private String openingDate;
	private String closingDate;
	private String finalClosingDate;
	private boolean isDelete;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}
	public String getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	public String getFinalClosingDate() {
		return finalClosingDate;
	}
	public void setFinalClosingDate(String finalClosingDate) {
		this.finalClosingDate = finalClosingDate;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
