package com.ewsd.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_categories")
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="name", length=50, nullable=false)
	private String name;
	
	@Column(name = "opening_date")
	private LocalDate openingDate;

	@Column(name = "closing_date")
	private LocalDate closingDate;
	
	@Column(name = "final_closing_date")
	private LocalDate finalClosingDate;

	@ManyToOne
	private Department dept;
	
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

	public Category(Long id, String name, LocalDate openingDate, LocalDate closingDate, LocalDate finalClosingDate,
			Department dept, Boolean isDelete, User entryBy, LocalDateTime entryDate, User updateBy,
			LocalDateTime updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.openingDate = openingDate;
		this.closingDate = closingDate;
		this.finalClosingDate = finalClosingDate;
		this.dept = dept;
		this.isDelete = isDelete;
		this.entryBy = entryBy;
		this.entryDate = entryDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", openingDate=" + openingDate + ", closingDate=" + closingDate
				+ ", finalClosingDate=" + finalClosingDate + ", dept=" + dept + ", isDelete=" + isDelete + ", entryBy="
				+ entryBy + ", entryDate=" + entryDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}



	
	
	
}
