package com.wellsfargo.batch5.pms.service;

import java.time.LocalDate;
import java.util.List;

import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;
import com.wellsfargo.batch5.pms.model.InvestorStockDetailsModel;
import com.wellsfargo.batch5.pms.model.TransactionModel;

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

	public CompanyModel getCompanyDetails(Integer companyId);

	public void updateRecentCompanies(Integer companyCode, String userName);

	public List<CompanyModel> getRecentCompanies(String name);

	public List<String> getSector();

	public List<CompanyModel> getCompanyBySector(String sector);

	public List<CompanyModel> getSelectedCompaniesByCode(String companySelected);

	public void addMoneytoWallet(String name, Double amount);

	public List<TransactionModel> getPortfolioReport(String userName,String report, LocalDate fromDate, LocalDate toDate, String month)throws PortfolioException;
		
	public void updateInvestorHome(String userName, Double earnedAmount, Double investedAmount, Double currentPortfolioValue) throws PortfolioException;

	public Double[] getAmountEarnedforlast10Weeks(String name);
	
	
}
