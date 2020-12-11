package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserLoginModel {

	@NotNull(message="User Name cannot be null")
	@NotBlank(message="User Name cannot be blank")
	private String userName;
	
	@NotNull(message="Password cannot be null")
	@NotBlank(message="Password cannot be blank")
	private String password;

	private String role;
	
	public UserLoginModel()
	{
		
	}

	public UserLoginModel(
			@NotNull(message = "User Name cannot be null") @NotBlank(message = "User Name cannot be blank") String userName,
			@NotNull(message = "Password cannot be null") @NotBlank(message = "Password cannot be blank") String password,
			String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}


