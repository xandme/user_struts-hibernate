package com.qingshixun.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private Boolean gender;
	private Date createDate=new Date(System.currentTimeMillis());
	private Date updateDate=new Date(System.currentTimeMillis());
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	public UserModel(int id, String name, String email, Boolean gender, Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public UserModel(String name, String email, Boolean gender, Date createDate, Date updateDate) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public UserModel() {
		super();
	}
	public UserModel(int id) {
		super();
		this.id = id;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	
}
