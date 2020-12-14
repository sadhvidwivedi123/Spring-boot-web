package com.wellsfargo.batch5.pms.service;

import java.util.List;

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

	public void sellCommodity(String userName,String commodityName, double parseDouble, int parseInt, double parseDouble2);
	
	
}
