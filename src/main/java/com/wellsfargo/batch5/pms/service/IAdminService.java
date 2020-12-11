package com.wellsfargo.batch5.pms.service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.UserModel;

public interface IAdminService {
	UserModel addbackOfficeUser(UserModel user)throws PortfolioException;

}
