package com.wellsfargo.batch5.pms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommisionModel;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.StockModel;
import com.wellsfargo.batch5.pms.repo.CommodityRepo;
import com.wellsfargo.batch5.pms.repo.CompanyRepo;
import com.wellsfargo.batch5.pms.repo.StockRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;
@Service
public class BackOfficeUserServiceImpl implements IBackOfficeUserService{
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private StockRepo stockRepo;
	
	@Autowired
	private CommodityRepo commodityRepo;
	
	@Transactional
	@Override
	public CommodityModel addCommodity(CommodityModel commodity) throws PortfolioException {
		if(commodity!=null) {
			if(!commodityRepo.existsById(commodity.getCommodityCode())) {
				if(!commodityRepo.existsByCommodityName(commodity.getCommodityName().toUpperCase())) {
				
				commodityRepo.save(PortfolioParser.parse(commodity));			
			
			}
				else
				{
				
					throw new PortfolioException("Commodity "+commodity.getCommodityName()+" already exists!");
				}
				
			}
			else
			{
			
				throw new PortfolioException("Commodity Id already exists!");
			}
			
		}
		
		return commodity;
	}
	
	@Transactional
	@Override
	public StockModel addStock(StockModel stock) throws PortfolioException {
		if (stock != null) {
			if (companyRepo.existsById(stock.getCompanyId())) {
				
				if (stockRepo.findByCompany(companyRepo.findById(stock.getCompanyId()).get())==null) {
					
					CompanyModel company=PortfolioParser.parse(companyRepo.findById(stock.getCompanyId()).get());
					stock.setCompany(company);
					stockRepo.save(PortfolioParser.parse(stock));

				} else {

					throw new PortfolioException("Stock with the Company Code already exists!");
				}
			} else {
				throw new PortfolioException(
						"Company IPO is not listed. Please create company IPO first to add its stock");
			}

		}

		return stock;
	}
	@Transactional
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
	@Transactional
	@Override
	public CommodityModel modifyCommodity(CommodityModel commodity) throws PortfolioException {
		if(commodity!=null) {
			
			if(commodityRepo.existsByCommodityName(commodity.getCommodityName()))
			{
			Integer temp = commodityRepo.findByCommodityName(commodity.getCommodityName()).getCommodityCode();
				if(temp==commodity.getCommodityCode()) {
				
				commodityRepo.save(PortfolioParser.parse(commodity));			
			
			}
				else
				{
				
					throw new PortfolioException("Commodity "+commodity.getCommodityName()+" already exists!");
				}
			}
			else
			{
				commodityRepo.save(PortfolioParser.parse(commodity));	
			}
			}
		
		
		return commodity;
	}
	@Transactional
	@Override
	public StockModel modifyStock(StockModel stock) throws PortfolioException {
		if (stock != null) {
			if (companyRepo.existsById(stock.getCompanyId())) {
					CompanyModel company=PortfolioParser.parse(companyRepo.findById(stock.getCompanyId()).get());
					stock.setCompany(company);
					stock.setStockId(stockRepo.findByCompany(companyRepo.findById(stock.getCompanyId()).get()).getStockId());
					stockRepo.update(stock.getStockId(),stock.getStockExchange(),stock.getCurrentPrice(),stock.getDate(),stock.getTime());
			}
			else
			{
				throw new PortfolioException("Company doesnot Exist. Please try again!");
			}
		}

		return stock;
	}
	@Transactional
	@Override
	public CompanyModel modifyCompany(CompanyModel company) throws PortfolioException {
		if(company!=null) {
			if(companyRepo.existsById(company.getCompanyCode())) {

				companyRepo.save(PortfolioParser.parse(company));			
			
			}
			else
			{
			
				throw new PortfolioException("Company Code does not exists!");
			}
			
		}
		
		return company;
	}

	@Override
	public void generateReport(CommisionModel commission) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<CompanyModel> getCompanyList() throws PortfolioException {
		
		List<CompanyEntity> entities= companyRepo.findAll();
		 
		return entities.stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}


	@Override
	public List<StockModel> getStockList() throws PortfolioException {
		List<StockEntity> entities= stockRepo.findAll();
		 
		return entities.stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}


	@Override
	public List<CommodityModel> getCommodityList() throws PortfolioException {
		List<CommodityEntity> entities= commodityRepo.findAll();
		 
		return entities.stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}


	@Override
	public CommodityModel getCommodityByCommodityCode(Integer commodityCode) throws PortfolioException {
		// TODO Auto-generated method stub
		return PortfolioParser.parse(commodityRepo.findById(commodityCode).get());
	}
	@Override
	public StockModel getStockByCompanyCode(Integer companyCode) throws PortfolioException {
		// TODO Auto-generated method stub
		
		return PortfolioParser.parse(stockRepo.findByCompany(companyRepo.findById(companyCode).get()));
	}


	@Override
	public CompanyModel getCompanyByCompanyCode(Integer companyCode) throws PortfolioException {
		// TODO Auto-generated method stub
		return PortfolioParser.parse(companyRepo.findById(companyCode).get());
	}

	@Override
	public CommodityModel getCommodityByCommodityName(String commodityName) throws PortfolioException {
		// TODO Auto-generated method stub
		return PortfolioParser.parse(commodityRepo.findByCommodityName(commodityName.toUpperCase()));
	}

}
