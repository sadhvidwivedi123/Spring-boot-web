package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InvestorRegisterModel {
	
private Integer userId;
	
	@NotNull(message="User Name cannot be null")
	@NotBlank(message="User Name cannot be blank")
	@Size(min=4, max=20, message="User Name should be between 4 to 20 characters")
	private String userName;
	
	@NotNull(message="Password cannot be null")
	@NotBlank(message="Password cannot be blank")
	@Size(min=4, max=20, message="Password should be between 4 to 20 characters")
	private String password;
	
	private String confirmPassword;
	
	@NotNull(message="Name cannot be null")
	@NotBlank(message="Name cannot be blank")
	@Size(min=4, message="Name should be more than 4 characters")
	private String name;
	
	@NotNull(message="Email cannot be null")
	@NotBlank(message="Email cannot be blank")
	@Email(message="Invalid email format")
	private String emailId;
	
	@NotNull(message="Phone number cannot be null")
	@NotBlank(message="Phone number cannot be blank")
	@Size(min=10,max=10, message="Phone number should have 10 digits")
	private String phNumber;
	
	private String role;
	
	@NotNull(message="PAN cannot be null")
	@NotBlank(message="PAN cannot be blank")
	@Size(min=10, max=10, message="PAN should be 10 alphanumeric")
	private String panId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public InvestorRegisterModel(Integer userId,
			@NotNull(message = "User Name cannot be null") @NotBlank(message = "User Name cannot be blank") @Size(min = 4, max = 20, message = "User Name should be between 4 to 20 characters") String userName,
			@NotNull(message = "Password cannot be null") @NotBlank(message = "Password cannot be blank") @Size(min = 4, max = 20, message = "Password should be between 4 to 20 characters") String password,
			@NotNull(message = "Confirm Password cannot be null") @NotBlank(message = "Confirm Password cannot be blank") @Size(min = 4, max = 20, message = "Confirm Password should be between 4 to 20 characters") String confirmPassword,
			@NotNull(message = "Name cannot be null") @NotBlank(message = "Name cannot be blank") @Size(min = 4, message = "Name should be more than 4 characters") String name,
			@NotNull(message = "Email cannot be null") @NotBlank(message = "Email cannot be blank") @Email(message = "Invalid email format") String emailId,
			@NotNull(message = "Phone number cannot be null") @NotBlank(message = "Phone number cannot be blank") @Size(min = 10, max = 10, message = "Phone number should have 10 digits") String phNumber,
			@NotNull(message = "Role cannot be null") @NotBlank(message = "Role cannot be blank") String role,
			@NotNull(message = "PAN cannot be null") @NotBlank(message = "PAN cannot be blank") @Size(min = 10, max = 10, message = "PAN should be 10 alphanumeric") String panId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.name = name;
		this.emailId = emailId;
		this.phNumber = phNumber;
		this.role = role;
		this.panId = panId;
	}
	
	public InvestorRegisterModel()
	{
		
	}

}
