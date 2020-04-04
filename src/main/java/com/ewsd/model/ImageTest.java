package com.ewsd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_test")
public class ImageTest implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name = "e_date")
	private String entryDate;
	
	@Column(name = "u_date")
	private String updateDate;

	@Column(name = "logo", nullable = false)
	private String logo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "ImageTest [id=" + id + ", name=" + name + ", userName=" + userName + ", location=" + location
				+ ", isDelete=" + isDelete + ", entryDate=" + entryDate + ", updateDate=" + updateDate + ", logo="
				+ logo + ", getId()=" + getId() + ", getName()=" + getName() + ", getUserName()=" + getUserName()
				+ ", getLocation()=" + getLocation() + ", getIsDelete()=" + getIsDelete() + ", getEntryDate()="
				+ getEntryDate() + ", getUpdateDate()=" + getUpdateDate() + ", getLogo()=" + getLogo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public ImageTest(long id, String name, String userName, String location, Boolean isDelete, String entryDate,
			String updateDate, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.location = location;
		this.isDelete = isDelete;
		this.entryDate = entryDate;
		this.updateDate = updateDate;
		this.logo = logo;
	}

	public ImageTest() {
		super();
	}

}
