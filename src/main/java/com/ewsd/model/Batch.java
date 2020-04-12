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
@Table(name = "tbl_batch")
public class Batch implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "batch_name")
	private String batchName;
	
	@Column(name = "academic_year")
	private String academicYear;
	
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

	public Batch() {
	}


	public Batch(Long id,String batchName, String academicYear, Boolean isDelete, User entryBy, LocalDateTime entryDate, User updateBy, LocalDateTime updateDate) {
		this.id=id;
		this.batchName = batchName;
		this.academicYear = academicYear;
		this.isDelete = isDelete;
		this.entryBy = entryBy;
		this.entryDate = entryDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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


	@Override
	public String toString() {
		return "Batch{" +
				"id=" + id +
				", batchName='" + batchName + '\'' +
				", academicYear='" + academicYear + '\'' +
				", isDelete=" + isDelete +
				", entryBy=" + entryBy +
				", entryDate=" + entryDate +
				", updateBy=" + updateBy +
				", updateDate=" + updateDate +
				'}';
	}
}
