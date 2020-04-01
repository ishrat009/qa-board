package com.ewsd.dto;

import java.io.Serializable;
import java.time.LocalDate;


import com.ewsd.model.Department;

public class CategoryDto implements Serializable {


	private Long id;
	
	private String name;
	
	private LocalDate openingDate;

	private LocalDate closingDate;
	
	private LocalDate finalClosingDate;
	
	private Department dept;
	
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

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public LocalDate getFinalClosingDate() {
		return finalClosingDate;
	}

	public void setFinalClosingDate(LocalDate finalClosingDate) {
		this.finalClosingDate = finalClosingDate;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", openingDate=" + openingDate + ", closingDate="
				+ closingDate + ", finalClosingDate=" + finalClosingDate + ", dept=" + dept + ", isDelete=" + isDelete
				+ "]";
	}
}

