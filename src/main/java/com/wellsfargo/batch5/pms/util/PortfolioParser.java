package com.wellsfargo.batch5.pms.util;

import org.springframework.format.datetime.joda.LocalDateParser;

import com.wellsfargo.batch5.pms.entity.BackOfficeUserEntity;
import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.InvestorCommodityDetailsEntity;
import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.InvestorStockDetailsEntity;
import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;
import com.wellsfargo.batch5.pms.entity.UserEntity;
import com.wellsfargo.batch5.pms.model.BackOfficeUserModel;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;
import com.wellsfargo.batch5.pms.model.InvestorModel;
import com.wellsfargo.batch5.pms.model.InvestorRegisterModel;
import com.wellsfargo.batch5.pms.model.InvestorStockDetailsModel;
import com.wellsfargo.batch5.pms.model.PortfolioWalletModel;
import com.wellsfargo.batch5.pms.model.StockModel;
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
	
	/*public static BackOfficeUserModel parseUserToBackOfficeUser(UserEntity source) {
		BackOfficeUserModel target=new BackOfficeUserModel();
		target.setUserId(source.getUserId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		target.setPhNumber(source.getPhNumber());
		target.setEmailId(source.getEmailId());
		//target.setRole(source.getRole());
		return target;
	}
	*/
	
	public static BackOfficeUserEntity parseUserToBackOfficeUser(UserModel source) {
		BackOfficeUserEntity target=new BackOfficeUserEntity();
		//target.setUserId(source.getUserId());
		target.setUserName(source.getUserName());
		target.setPassword(source.getPassword());
		target.setName(source.getName());
		target.setPhNumber(source.getPhNumber());
		target.setEmailId(source.getEmailId());
		target.setRole("back_office_user");
		return target;
	}
	
	
	
	public static PortfolioWalletEntity parse(PortfolioWalletModel source) {
		PortfolioWalletEntity target=new PortfolioWalletEntity();
		target.setWalletBalance(source.getWalletBalance());
		return target;
	}
	public static CompanyEntity parse(CompanyModel source) {
		CompanyEntity target=new CompanyEntity();
		target.setCompanyCode(source.getCompanyCode());
		target.setCompanyTitle(source.getCompanyTitle());
		target.setCurrency(source.getCurrency());
		target.setOpenSharePrice(source.getOpenSharePrice());
		target.setOperations(source.getOperations());
		target.setSector(source.getSector());
		target.setShareCount(source.getShareCount());
		target.setTurnOver(source.getTurnOver());
		
		return target;
	}
	public static CompanyModel parse(CompanyEntity source) {
		CompanyModel target=new CompanyModel();
		target.setCompanyCode(source.getCompanyCode());
		target.setCompanyTitle(source.getCompanyTitle());
		target.setCurrency(source.getCurrency());
		target.setOpenSharePrice(source.getOpenSharePrice());
		target.setOperations(source.getOperations());
		target.setSector(source.getSector());
		target.setShareCount(source.getShareCount());
		target.setTurnOver(source.getTurnOver());
		
		return target;
	}
	public static StockEntity parse(StockModel source) {
		StockEntity target=new StockEntity();
		target.setCurrentPrice(source.getCurrentPrice());
		target.setDate(source.getDate());
		target.setStockExchange(source.getStockExchange());
		//target.setCompanyId(source.getCompanyId());
		target.setTime(source.getTime());
		target.setCompany(PortfolioParser.parse(source.getCompany()));
		return target;
	}
	
	public static StockModel parse(StockEntity source) {
		StockModel target=new StockModel();
		target.setCurrentPrice(source.getCurrentPrice());
		target.setDate(source.getDate());
		target.setStockExchange(source.getStockExchange());
		//target.setCompanyId(source.getCompanyId());
		target.setTime(source.getTime());
		target.setCompany(PortfolioParser.parse(source.getCompany()));
		target.setStockId(source.getStockId());
		target.setCompanyId(source.getCompany().getCompanyCode());
		return target;
	}
	
	public static CommodityEntity parse(CommodityModel source) {
		
		CommodityEntity target=new CommodityEntity();
		target.setCommodityCode(source.getCommodityCode());
		target.setCommodityName(source.getCommodityName().toUpperCase());
		target.setCurrentPrice(source.getCurrentPrice());
		return target;
	}
	
	public static CommodityModel parse(CommodityEntity source) {
		
		CommodityModel target=new CommodityModel();
		target.setCommodityCode(source.getCommodityCode());
		target.setCommodityName(source.getCommodityName().toUpperCase());
		target.setCurrentPrice(source.getCurrentPrice());
		return target;
	}
	public static InvestorCommodityDetailsModel parse(InvestorCommodityDetailsEntity source) {
		// TODO Auto-generated method stub
		InvestorCommodityDetailsModel target=new InvestorCommodityDetailsModel();
		target.setCommodity(PortfolioParser.parse(source.getCommodity()));
		target.setDate(source.getDate());
		target.setInvestor(PortfolioParser.parse(source.getInvestor()));
		target.setQuantity(source.getUnit());
		return target;
	}
	public static InvestorModel parse(InvestorEntity source) 
	{
		InvestorModel target=new InvestorModel();
		target.setUserId(source.getUserId());
		return target;
	}
	public static InvestorEntity parse(InvestorModel source) 
	{
		InvestorEntity target=new InvestorEntity();
		target.setUserId(source.getUserId());
		return target;
	}
	public static InvestorStockDetailsModel parse(InvestorStockDetailsEntity source) {
		// TODO Auto-generated method stub
		InvestorStockDetailsModel target=new InvestorStockDetailsModel();
		target.setDate(source.getDate());
		target.setInvestor(PortfolioParser.parse(source.getInvestor()));
		target.setStock(PortfolioParser.parse(source.getStock()));
		target.setQuantity(source.getUnit());
		target.setInvestorStockId(source.getInvestorStockId());
		return target;
	}
	
}
