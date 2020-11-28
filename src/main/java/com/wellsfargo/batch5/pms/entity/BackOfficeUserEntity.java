package com.wellsfargo.batch5.pms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("back_office_user")
@Table(name="back_office_user")
public class BackOfficeUserEntity extends UserEntity{

	
	public BackOfficeUserEntity()
	{
		
	}

	public BackOfficeUserEntity(Integer userId, String userName, String password, String role, String emailId, String phNumber, String name) {
		super(userId, userName, password, role, emailId, phNumber, name);
		
	}


}
