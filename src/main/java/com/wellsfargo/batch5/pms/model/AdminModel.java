package com.wellsfargo.batch5.pms.model;

public class AdminModel extends UserModel{

	//public String userKey;
	
		
	public AdminModel()
	{
		
	}
	
	public AdminModel(Integer userId, String userName, String password, String role, String emailId, String phNumber, String name) {
		super(userId, userName, password, role, emailId, phNumber, name);
		//this.userKey = userKey;
		
	}



	
	
	
	
}
