package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class UserModel {
	
	private Integer userId;
	
	@NotNull(message="User Name cannot be null")
	@NotBlank(message="User Name cannot be blank")
	@Size(min=4, max=20, message="User Name should be between 4 to 20 characters")
	private String userName;
	
	@NotNull(message="Password cannot be null")
	@NotBlank(message="Password cannot be blank")
	@Size(min=4, max=20, message="Password should be between 4 to 20 characters")
	private String password;
	@NotNull(message="Name cannot be null")
	@NotBlank(message="Name cannot be blank")
	@Size(min=4, message="Name should be more than 4 characters")
	private String name;
	
	//@Column(name="role")
	//public String role;
	@NotNull(message="Email cannot be null")
	@NotBlank(message="Email cannot be blank")
	@Email(message="Invalid email format")
	private String emailId;
	
	@NotNull(message="Phone number cannot be null")
	@NotBlank(message="Phone number cannot be blank")
	@Size(min=10,max=10, message="Phone number should have 10 digits")
	private String phNumber;
	
	public UserModel()
	{
		
	}
	
	public UserModel(Integer userId, String userName,String password, String role, String emailId, String phNumber, String name) {
		super();
		this.userId = userId;
		this.userName=userName;
		this.password = password;
		this.name= name;
		this.emailId = emailId;
		this.phNumber = phNumber;
	}
	public String getUserName() {
		return name;
	}

	public void setUserName(String name) {
		this.name = name;
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
	//public String getRoleId() {
	//	return role;
	//}
	//public void setRoleId(String role) {
	//	this.role = role;
	//}
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
		
}
