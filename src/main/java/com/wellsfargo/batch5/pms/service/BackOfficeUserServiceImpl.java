package com.wellsfargo.batch5.pms.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.wellsfargo.batch5.pms.model.TransactionModel;
import com.wellsfargo.batch5.pms.repo.CommisionRepo;
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
	
	@Autowired
	private CommisionRepo commisionRepo;
	
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

	@Override
	public List<CommisionModel> getCommissionReport(String report, LocalDate fdate, LocalDate tdate, String month) throws PortfolioException {
		List<CommisionModel> te=new ArrayList<CommisionModel>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(report.trim().toLowerCase().equals("annual"))
		{
			fdate=LocalDate.parse("2020-01-01",formatter);
			tdate=LocalDate.now();
		}
		else if(report.trim().toLowerCase().equals("monthly"))
		{
			switch(month.trim().toLowerCase())
			{
			case "january":
				fdate=LocalDate.parse("2020-01-01",formatter);
				tdate=LocalDate.parse("2020-01-31",formatter);
				break;
				
			case "february":
				fdate=LocalDate.parse("2020-02-01",formatter);
				tdate=LocalDate.parse("2020-02-28",formatter);
				break;
				
			case "march":
				fdate=LocalDate.parse("2020-03-01",formatter);
				tdate=LocalDate.parse("2020-03-31",formatter);
				break;
				
			case "april":
				fdate=LocalDate.parse("2020-04-01",formatter);
				tdate=LocalDate.parse("2020-04-30",formatter);
				break;
				
			case "may":
				fdate=LocalDate.parse("2020-05-01",formatter);
				tdate=LocalDate.parse("2020-05-31",formatter);
				break;
				
			case "june":
				fdate=LocalDate.parse("2020-06-01",formatter);
				tdate=LocalDate.parse("2020-06-30",formatter);
				break;
				
			case "july":
				fdate=LocalDate.parse("2020-07-01",formatter);
				tdate=LocalDate.parse("2020-07-31",formatter);
				break;
				
			case "august":
				fdate=LocalDate.parse("2020-08-01",formatter);
				tdate=LocalDate.parse("2020-08-31",formatter);
				break;
				
			case "september":
				fdate=LocalDate.parse("2020-09-01",formatter);
				tdate=LocalDate.parse("2020-09-30",formatter);
				break;
				
			case "october":
				fdate=LocalDate.parse("2020-10-01",formatter);
				tdate=LocalDate.parse("2020-10-31",formatter);
				break;
				
			case "november":
				fdate=LocalDate.parse("2020-11-01",formatter);
				tdate=LocalDate.parse("2020-11-30",formatter);
				break;
				
			case "december":
				fdate=LocalDate.parse("2020-12-01",formatter);
				tdate=LocalDate.parse("2020-12-31",formatter);
				break;
			default:
				throw new PortfolioException("Error while generating Commision Report");
			}
		}
		
		te=commisionRepo.findAllByDateBetween(fdate,tdate).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
		
		return te;
	}

}
