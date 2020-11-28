package com.wellsfargo.batch5.pms.model;

public class BackOfficeUserModel extends UserModel{

	
	public BackOfficeUserModel()
	{
		
	}

	public BackOfficeUserModel(Integer userId, String userName, String password, String role, String emailId, String phNumber, String name) {
		super(userId, userName, password, role, emailId, phNumber, name);
		
	}


}
