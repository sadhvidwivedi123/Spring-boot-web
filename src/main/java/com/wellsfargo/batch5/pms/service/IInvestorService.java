package com.wellsfargo.batch5.pms.service;

import java.util.List;

import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;

import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;
import com.wellsfargo.batch5.pms.model.InvestorStockDetailsModel;

public interface IInvestorService {

	public Double getCurrentPortfolioValue(String userName)throws PortfolioException;
	
	public Double getAmountInvested(String userName)throws PortfolioException;
	
	public Double getAmountEarned(String userName)throws PortfolioException;
	
	public Double getPortfolioWalletAmount(String userName)throws PortfolioException;
	
	public String getCurrency(String userName)throws PortfolioException;
	
	public List<InvestorCommodityDetailsModel> getInvestorCommodityList() throws PortfolioException;
	
	public List<InvestorStockDetailsModel> getInvestorStockList() throws PortfolioException;

	public void sellCommodity(String userName,String commodityName, double currentPrice, int quantity, double totalPrice);
	
	public void buyCommodity(String userName,String commodityName, double currentPrice, int quantity, double totalPrice);
	
	public void sellStock(String userName,String stockId, double currentPrice, int quantity, double totalPrice)throws PortfolioException;
	
	public void buyStock(String userName,Integer stockId, double currentPrice, int quantity, double totalPrice);
	
	public boolean hasSufficientWalletBalance(String userName, Double transactionAmount);

	public List getCompanyListBasedOnText(String companyText);
	
	
	
}
