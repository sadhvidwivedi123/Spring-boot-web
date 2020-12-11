package com.wellsfargo.batch5.pms.util;

import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;
import com.wellsfargo.batch5.pms.entity.UserEntity;
import com.wellsfargo.batch5.pms.model.InvestorRegisterModel;
import com.wellsfargo.batch5.pms.model.PortfolioWalletModel;
import com.wellsfargo.batch5.pms.model.UserModel;

public class PortfolioParser {
	public static UserModel parse(UserEntity source) {
		UserModel target=new UserModel();
		target.setUserId(source.getUserId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		target.setPhNumber(source.getPhNumber());
		target.setEmailId(source.getEmailId());
		//target.setRole(source.getRole());
		return target;
	}
	public static UserEntity parse(UserModel source) {
		UserEntity target=new UserEntity();
		target.setUserId(source.getUserId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		//target.setRole(source.getRole());
		target.setEmailId(source.getEmailId());
		target.setPhNumber(source.getPhNumber());
		
		
		return target;
		
	}
	public static InvestorRegisterModel parseUserToInvestor(UserEntity source) {
		InvestorRegisterModel target=new InvestorRegisterModel();
		target.setUserId(source.getUserId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		target.setPhNumber(source.getPhNumber());
		target.setEmailId(source.getEmailId());
		//target.setRole(source.getRole());
		return target;
	}
	/*public static UserEntity parse(InvestorRegisterModel source) {
		UserEntity target=new UserEntity();
		target.setUserId(source.getUserId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		//target.setRole("investor");
		target.setEmailId(source.getEmailId());
		target.setPhNumber(source.getPhNumber());
		
		
		return target;
		
	}*/
	public static InvestorEntity parse(InvestorRegisterModel source) {
		InvestorEntity target=new InvestorEntity();
		PortfolioWalletModel wallet=new PortfolioWalletModel();
		wallet.setWalletBalance(1500.00);
		target.setUserId(source.getUserId());
		target.setPanId(source.getPanId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		//target.setRole("investor");
		target.setIsNewUser(true);
		target.setEmailId(source.getEmailId());
		target.setPhNumber(source.getPhNumber());
		target.setPortWallet(PortfolioParser.parse(wallet));
		return target;
		
	}
	
	public static PortfolioWalletEntity parse(PortfolioWalletModel source) {
		PortfolioWalletEntity target=new PortfolioWalletEntity();
		target.setWalletBalance(source.getWalletBalance());
		return target;
	}

}
