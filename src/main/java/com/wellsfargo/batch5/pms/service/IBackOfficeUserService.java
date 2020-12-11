package com.wellsfargo.batch5.pms.service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommisionModel;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.StockModel;

public interface IBackOfficeUserService {

	CommodityModel addCommodity(CommodityModel commodity)throws PortfolioException;
	
	StockModel addStock(StockModel stock)throws PortfolioException;
	
	CompanyModel addCompany(CompanyModel company)throws PortfolioException;
	
	CommodityModel modifyCommodity(CommodityModel commodity)throws PortfolioException;
	
	StockModel modifyStock(StockModel stock)throws PortfolioException;
	
	CompanyModel modifyCompany(CompanyModel company)throws PortfolioException;
	
	void generateReport(CommisionModel commission)throws PortfolioException;
}
