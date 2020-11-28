package com.wellsfargo.batch5.pms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("admin")
@Table(name="admin")
public class AdminEntity extends UserEntity{

	//public String userKey;
	
		
	public AdminEntity()
	{
		
	}
	
	public AdminEntity(Integer userId, String userName, String password, String role, String emailId, String phNumber, String name) {
		super(userId, userName, password, role, emailId, phNumber, name);
		//this.userKey = userKey;
		
	}



	
	
	
	
}
