package com.wellsfargo.batch5.pms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@DiscriminatorColumn(name="role",discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name="user_details")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorValue("direct_user")
public class UserEntity {
	@GeneratedValue
	@Id
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role", insertable=false, updatable = false)
	private String role;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="phone")
	private String phNumber;
	
	public UserEntity()
	{
		
	}
	
	public UserEntity(Integer userId, String userName,String password, String role, String emailId, String phNumber, String name) {
		super();
		this.userId = userId;
		this.userName=userName;
		this.password = password;
		this.name= name;
		this.emailId = emailId;
		this.phNumber = phNumber;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
		
}
