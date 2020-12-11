package com.wellsfargo.batch5.pms.service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.InvestorRegisterModel;
import com.wellsfargo.batch5.pms.model.UserModel;

public interface IHomeService {
	InvestorRegisterModel register(InvestorRegisterModel user)throws PortfolioException;
	
	void login(UserModel user)throws PortfolioException;

}
