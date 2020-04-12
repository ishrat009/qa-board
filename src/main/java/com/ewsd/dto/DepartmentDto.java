package com.ewsd.dto;

import java.io.Serializable;

import com.ewsd.model.Batch;
import com.ewsd.model.User;

public class DepartmentDto implements Serializable {

	private Long id;

	private String deptName;

	private Batch batch;

	private Boolean isDelete;

	private User entryBy;

	public DepartmentDto() {
		super();
	}

	public DepartmentDto(Long id, String deptName, Batch batch, Boolean isDelete, User entryBy) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.batch = batch;
		this.isDelete = isDelete;
		this.entryBy = entryBy;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public User getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(User entryBy) {
		this.entryBy = entryBy;
	}

	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", deptName=" + deptName + ", batch=" + batch + ", isDelete=" + isDelete
				+ ", entryBy=" + entryBy + "]";
	}

} // end of Class
