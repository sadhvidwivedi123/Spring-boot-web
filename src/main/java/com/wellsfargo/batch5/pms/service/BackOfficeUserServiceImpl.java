package com.wellsfargo.batch5.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommisionModel;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.StockModel;
import com.wellsfargo.batch5.pms.repo.CompanyRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;
@Service
public class BackOfficeUserServiceImpl implements IBackOfficeUserService{
	@Autowired
	private CompanyRepo companyRepo;
	
	@Override
	public CommodityModel addCommodity(CommodityModel commodity) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockModel addStock(StockModel stock) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyModel addCompany(CompanyModel company) throws PortfolioException {
		if(company!=null) {
			if(!companyRepo.existsById(company.getCompanyCode())) {

				companyRepo.save(PortfolioParser.parse(company));			
			
			}
			else
			{
			
				throw new PortfolioException("Company Code already exists!");
			}
			
		}
		
		return company;
	}

	@Override
	public CommodityModel modifyCommodity(CommodityModel commodity) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockModel modifyStock(StockModel stock) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyModel modifyCompany(CompanyModel company) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateReport(CommisionModel commission) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

}
