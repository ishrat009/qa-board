package com.ewsd.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_department")
public class Department  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@ManyToOne
	private Batch batch;
	
	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@ManyToOne
	@JoinColumn(name = "e_by")
	private User entryBy;
	
	@Column(name = "e_date")
	private LocalDateTime entryDate;
	
	@ManyToOne
	@JoinColumn(name = "u_by")
	private User updateBy;
	
	@Column(name = "u_date")
	private LocalDateTime updateDate;

	
	public Department() {
		super();
	}

	public Department(Long id, String deptName, Batch batch, Boolean isDelete, User entryBy, LocalDateTime entryDate,
			User updateBy, LocalDateTime updateDate) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.batch = batch;
		this.isDelete = isDelete;
		this.entryBy = entryBy;
		this.entryDate = entryDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", batch=" + batch + ", isDelete=" + isDelete
				+ ", entryBy=" + entryBy + ", entryDate=" + entryDate + ", updateBy=" + updateBy + ", updateDate="
				+ updateDate + "]";
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

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
} // End of Class
