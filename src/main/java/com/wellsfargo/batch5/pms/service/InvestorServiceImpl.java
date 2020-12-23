package com.wellsfargo.batch5.pms.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.entity.CommisionEntity;
import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.InvestorCommodityDetailsEntity;
import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.InvestorStockDetailsEntity;
import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;
import com.wellsfargo.batch5.pms.entity.TransactionEntity;
import com.wellsfargo.batch5.pms.entity.UserEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommisionModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.InvestorAmountEarnedModel;
import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;
import com.wellsfargo.batch5.pms.model.InvestorStockDetailsModel;
import com.wellsfargo.batch5.pms.model.TransactionModel;
import com.wellsfargo.batch5.pms.repo.CommisionRepo;
import com.wellsfargo.batch5.pms.repo.CommodityRepo;
import com.wellsfargo.batch5.pms.repo.CompanyRepo;
import com.wellsfargo.batch5.pms.repo.InvestorAmountEarnedRepo;
import com.wellsfargo.batch5.pms.repo.InvestorCommodityDetailsRepo;
import com.wellsfargo.batch5.pms.repo.InvestorRepo;
import com.wellsfargo.batch5.pms.repo.InvestorStockDetailsRepo;
import com.wellsfargo.batch5.pms.repo.StockRepo;
import com.wellsfargo.batch5.pms.repo.TransactionRepo;
import com.wellsfargo.batch5.pms.repo.UserRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;

@Service
public class InvestorServiceImpl implements IInvestorService{

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private InvestorCommodityDetailsRepo investorCommodityDetailsRepo;
	
	@Autowired
	private InvestorStockDetailsRepo investorStockDetailsRepo;
	
	@Autowired
	private CommodityRepo commodityRepo; 
	
	@Autowired
	private StockRepo stockRepo; 
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CommisionRepo commissionRepo;
	
	@Autowired
	private InvestorRepo investorRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private InvestorAmountEarnedRepo investorAmountEarnedRepo;

	@Override
	public Double getCurrentPortfolioValue(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		Integer userId=userRepo.findByUserName(userName).getUserId();
		Double currentPortfolioValue=0.0;
		
		if(investorCommodityDetailsRepo.existsByInvestor(investorRepo.findById(userId).get())||investorStockDetailsRepo.existsByInvestor(investorRepo.findById(userId).get()))
		{
			
			List<InvestorCommodityDetailsModel> investorCommodityDetails=investorCommodityDetailsRepo.findAllByInvestor(investorRepo.findById(userId).get()).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
			if(investorCommodityDetails.size()>0)
			for(InvestorCommodityDetailsModel l:investorCommodityDetails)
			{
				currentPortfolioValue=currentPortfolioValue+l.getQuantity()*commodityRepo.findById(l.getCommodity().getCommodityCode()).get().getCurrentPrice();
			}
			
			List<InvestorStockDetailsModel> investorStockDetails=investorStockDetailsRepo.findAllByInvestor(investorRepo.findById(userId).get()).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
			if(investorStockDetails.size()>0)
			for(InvestorStockDetailsModel l:investorStockDetails)
			{
				currentPortfolioValue=currentPortfolioValue+l.getQuantity()*stockRepo.findById(l.getStock().getStockId()).get().getCurrentPrice();
			}
		}
		
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get();
		investor.setCurrentPortfolioValue(currentPortfolioValue);
		investorRepo.save(investor);
		return currentPortfolioValue;
	}

	@Override
	public Double getAmountInvested(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		if(investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getAmountInvested()==null)
			return 0.0;
		else
		return investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getAmountInvested();
	}

	@Override
	public Double getAmountEarned(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		Double amountEarned=0.0;
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get();
		if(investor.getAmountInvested()==null)
			amountEarned=0.0;
		else
			amountEarned=investor.getCurrentPortfolioValue()-investor.getAmountInvested();
		
		if(amountEarned<0)
			amountEarned=0.0;
			
		investor.setAmountEarned(amountEarned);
		investorRepo.save(investor);
		
		return amountEarned;
	}

	@Override
	public Double getPortfolioWalletAmount(String userName) throws PortfolioException {
		
		return investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getPortWallet().getWalletBalance();
	}

	@Override
	public String getCurrency(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvestorCommodityDetailsModel> getInvestorCommodityList() throws PortfolioException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Integer userId=userRepo.findByUserName(auth.getName()).getUserId();
		
		List<InvestorCommodityDetailsEntity> entities= investorCommodityDetailsRepo.findAllByInvestor(investorRepo.findById(userId).get());
		 
		return entities.stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public List<InvestorStockDetailsModel> getInvestorStockList() throws PortfolioException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Integer userId=userRepo.findByUserName(auth.getName()).getUserId();
		
		List<InvestorStockDetailsEntity> entities= investorStockDetailsRepo.findAllByInvestor(investorRepo.findById(userId).get());
		 
		return entities.stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public void sellCommodity(String userName,String commodityName, double price, int quantity, double totalPrice) {
		
		//portfolio wallet
		PortfolioWalletEntity pw=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getPortWallet();
		pw.setWalletBalance(pw.getWalletBalance()+totalPrice);
		investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().setPortWallet(pw);
		//commision
		CommisionEntity cm=new CommisionEntity(pw.getWalletBalance()*2/100, LocalDate.now());
		commissionRepo.save(cm);
		//comkmodity table update 
		InvestorCommodityDetailsEntity invComDetails= investorCommodityDetailsRepo.findByCommodityAndInvestor(commodityRepo.findByCommodityName(commodityName), investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get());
		if(invComDetails.getUnit()-quantity==0){
		investorCommodityDetailsRepo.deleteById(invComDetails.getInvestorCommKey());	
		}
		else
		{
		//invComDetails.setUnit(invComDetails.getUnit()-quantity);
		Integer key= invComDetails.getInvestorCommKey();
		quantity= invComDetails.getUnit()-quantity;
		LocalDate date= LocalDate.now();
		investorCommodityDetailsRepo.update(quantity,key,date);
		}
		//update user transaction table
				TransactionEntity te=new TransactionEntity(null, userRepo.findByUserName(userName).getUserId(), "sell", "commodity", totalPrice,LocalDate.now(),null,commodityName,quantity);
				transactionRepo.save(te);
				
		
	}
	@Override
	public void buyCommodity(String userName,String commodityName, double price, int quantity, double totalPrice) {
		
		//portfolio wallet
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get();
		PortfolioWalletEntity pw=investor.getPortWallet();
		pw.setWalletBalance(pw.getWalletBalance()-totalPrice);
		if(investor.getAmountInvested()!=null)
		investor.setAmountInvested(investor.getAmountInvested()+totalPrice);
		else
			investor.setAmountInvested(totalPrice);
		//investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().setPortWallet(pw);
		investorRepo.save(investor);
		
		//commodity table update
		try {
			if(investorCommodityDetailsRepo.existsByCommodity(commodityRepo.findByCommodityName(commodityName))&&investorCommodityDetailsRepo.existsByInvestor(investor))
			{
			InvestorCommodityDetailsEntity invComDetails= investorCommodityDetailsRepo.findByCommodityAndInvestor(commodityRepo.findByCommodityName(commodityName),investor);
			//invComDetails.setUnit(invComDetails.getUnit()-quantity);
			Integer key= invComDetails.getInvestorCommKey();
			quantity= invComDetails.getUnit()+quantity;
			LocalDate date= LocalDate.now();
			investorCommodityDetailsRepo.update(quantity,key,date);
			}
			else
			{
				investorCommodityDetailsRepo.saveAndFlush(new InvestorCommodityDetailsEntity(null, investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get(), commodityRepo.findByCommodityName(commodityName), quantity, LocalDate.now()));
			}
		} catch (PortfolioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//update user transaction table
		TransactionEntity te=new TransactionEntity(null, investor.getUserId(), "buy", "commodity", totalPrice,LocalDate.now(),null,commodityName,quantity);
		transactionRepo.save(te);
		
	}

	@Override
	public boolean hasSufficientWalletBalance(String userName, Double transactionAmount) {
	
		return investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getPortWallet().getWalletBalance()>=transactionAmount;
	}

	@Override
	public void sellStock(String userName, String stockId, double currentPrice, int quantity, double totalPrice) throws PortfolioException {
		//portfolio wallet
		PortfolioWalletEntity pw=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getPortWallet();
		pw.setWalletBalance(pw.getWalletBalance()+totalPrice);
		
		//investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().setPortWallet(pw);
		investorRepo.save((investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get()));
		
		//commodity table update
		try {
			if(investorStockDetailsRepo.existsByStock(stockRepo.findByStockId(Integer.parseInt(stockId))))
			{
			InvestorStockDetailsEntity invStockDetails= investorStockDetailsRepo.findByStockAndInvestor(stockRepo.findByStockId(Integer.parseInt(stockId)), investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get());
			//invComDetails.setUnit(invComDetails.getUnit()-quantity);
			Integer key= invStockDetails.getInvestorStockId();
			if(invStockDetails.getUnit()-quantity==0){
				investorStockDetailsRepo.deleteById(invStockDetails.getInvestorStockId());	
				}
			else
			{
			quantity= invStockDetails.getUnit()-quantity;
			LocalDate date= LocalDate.now();
			investorStockDetailsRepo.update(quantity,key,date);
			}
			}
			else
			{
				investorStockDetailsRepo.saveAndFlush(new InvestorStockDetailsEntity(null, investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get(), stockRepo.findByStockId(Integer.parseInt(stockId)), quantity, LocalDate.now()));
			}
		} catch (PortfolioException e) {
			// TODO Auto-generated catch block
			throw new PortfolioException("Error while selling the stock. Please try again later");
		}
		
		//update user transaction table
				TransactionEntity te=new TransactionEntity(null, userRepo.findByUserName(userName).getUserId(), "sell", "stock", totalPrice,LocalDate.now(),stockRepo.findById(Integer.parseInt(stockId)).get().getCompany().getCompanyTitle(),null,quantity);
				transactionRepo.save(te);
				
	}

	@Override
	public void buyStock(String userName, Integer stockId, double currentPrice, int quantity, double totalPrice) {

		//portfolio wallet
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get();
				PortfolioWalletEntity pw=investor.getPortWallet();
				pw.setWalletBalance(pw.getWalletBalance()-totalPrice);
				if(investor.getAmountInvested()!=null)
					investor.setAmountInvested(investor.getAmountInvested()+totalPrice);
					else
						investor.setAmountInvested(totalPrice);
				//investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().setPortWallet(pw);
				investorRepo.save((investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get()));
				
				//commodity table update
				try {
					if(investorStockDetailsRepo.existsByStock(stockRepo.findByStockId(stockId))&&investorStockDetailsRepo.existsByInvestor(investor))
					{
					InvestorStockDetailsEntity invStockDetails= investorStockDetailsRepo.findByStockAndInvestor(stockRepo.findByStockId(stockId),investor);
					//invComDetails.setUnit(invComDetails.getUnit()-quantity);
					Integer key= invStockDetails.getInvestorStockId();
					quantity= invStockDetails.getUnit()+quantity;
					LocalDate date= LocalDate.now();
					investorStockDetailsRepo.update(quantity,key,date);
					}
					else
					{
						investorStockDetailsRepo.saveAndFlush(new InvestorStockDetailsEntity(null, investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get(), stockRepo.findByStockId(stockId), quantity, LocalDate.now()));
					}
				} catch (PortfolioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//update user transaction table
				TransactionEntity te=new TransactionEntity(null, investor.getUserId(), "buy", "stock", totalPrice,LocalDate.now(),stockRepo.findById(stockId).get().getCompany().getCompanyTitle(),null,quantity);
				transactionRepo.save(te);
				
	}

	@Override
	public List<CompanyModel> getCompanyListBasedOnText(String companyText) {
		// TODO Auto-generated method stub
		return companyRepo.findByCompanyTitleContaining(companyText).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public CompanyModel getCompanyDetails(Integer companyId) {
		// TODO Auto-generated method stub
		return PortfolioParser.parse(companyRepo.findById(companyId).get());
	}

	@Override
	public void updateRecentCompanies(Integer companyCode, String userName) {
		// TODO Auto-generated method stub
		String temp="";
		String companyCodeStr=companyCode.toString();
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get();
		if(investor.getRecentCompanies()==null)
		{
			investor.setRecentCompanies(companyCodeStr);
		}
		else
		{
			if(!(investor.getRecentCompanies().contains(companyCodeStr+",")&&investor.getRecentCompanies().contains(","+companyCodeStr)))
			if(investor.getRecentCompanies().split(",").length>=5) //if it has 3 recent companies
			{
			temp=investor.getRecentCompanies()+","+companyCodeStr;
			temp=temp.substring(temp.indexOf(",")+1);
			investor.setRecentCompanies(temp);
			}
			else
			{
				investor.setRecentCompanies((investor.getRecentCompanies().toString()+","+companyCodeStr).toString());
			}
		}
		investorRepo.saveAndFlush(investor);
	}

	@Override
	public List<CompanyModel> getRecentCompanies(String name) {
		List<CompanyModel> list_recent_companies=new ArrayList<CompanyModel>();
		String recentCompanies=investorRepo.findById(userRepo.findByUserName(name).getUserId()).get().getRecentCompanies();
		if(recentCompanies!=null)
		for (String s:recentCompanies.split(","))
		{
			list_recent_companies.add(PortfolioParser.parse(companyRepo.findById(Integer.parseInt(s)).get()));
		}
		return list_recent_companies;
	}

	@Override
	public List<String> getSector() {
		List<String> sector_list=new ArrayList<String>();
		if(companyRepo.findAll()!=null && companyRepo.findAll().size()!=0)
		for(CompanyEntity e:companyRepo.findAll())
		{
			if(!sector_list.contains(e.getSector()))
					{
				sector_list.add(e.getSector());
					}
		}
		
		return sector_list;
	}

	@Override
	public List<CompanyModel> getCompanyBySector(String sector) {
		// TODO Auto-generated method stub
		 return companyRepo.findAllBySector(sector).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public List<CompanyModel> getSelectedCompaniesByCode(String companySelected) {
		// TODO Auto-generated method stub
		String[] selectedCompanies=companySelected.split(",");
		List<CompanyModel> cml=new ArrayList<CompanyModel>();
		for(String s:selectedCompanies)
		{
		 cml.add(getCompanyDetails(Integer.parseInt(s)));
		}
		return cml;
	}

	@Override
	public void addMoneytoWallet(String name, Double amount) {
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(name).getUserId()).get();
		PortfolioWalletEntity pw=investor.getPortWallet();
		pw.setWalletBalance(pw.getWalletBalance()+amount);
		investor.setPortWallet(pw);
		investorRepo.save(investor);
		
	}

	@Override
	public List<TransactionModel> getPortfolioReport(String userName,String report, LocalDate fromDate, LocalDate toDate, String month) throws PortfolioException {
		// TODO Auto-generated method stub
		
		List<TransactionModel> te=new ArrayList<TransactionModel>();
		List<TransactionModel> te1=new ArrayList<TransactionModel>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(report.trim().toLowerCase().equals("annual"))
		{
			fromDate=LocalDate.parse("2020-01-01",formatter);
			toDate=LocalDate.now();
		}
		else if(report.trim().toLowerCase().equals("monthly"))
		{
			switch(month.trim().toLowerCase())
			{
			case "january":
				fromDate=LocalDate.parse("2020-01-01",formatter);
				toDate=LocalDate.parse("2020-01-31",formatter);
				break;
				
			case "february":
				fromDate=LocalDate.parse("2020-02-01",formatter);
				toDate=LocalDate.parse("2020-02-28",formatter);
				break;
				
			case "march":
				fromDate=LocalDate.parse("2020-03-01",formatter);
				toDate=LocalDate.parse("2020-03-31",formatter);
				break;
				
			case "april":
				fromDate=LocalDate.parse("2020-04-01",formatter);
				toDate=LocalDate.parse("2020-04-30",formatter);
				break;
				
			case "may":
				fromDate=LocalDate.parse("2020-05-01",formatter);
				toDate=LocalDate.parse("2020-05-31",formatter);
				break;
				
			case "june":
				fromDate=LocalDate.parse("2020-06-01",formatter);
				toDate=LocalDate.parse("2020-06-30",formatter);
				break;
				
			case "july":
				fromDate=LocalDate.parse("2020-07-01",formatter);
				toDate=LocalDate.parse("2020-07-31",formatter);
				break;
				
			case "august":
				fromDate=LocalDate.parse("2020-08-01",formatter);
				toDate=LocalDate.parse("2020-08-31",formatter);
				break;
				
			case "september":
				fromDate=LocalDate.parse("2020-09-01",formatter);
				toDate=LocalDate.parse("2020-09-30",formatter);
				break;
				
			case "october":
				fromDate=LocalDate.parse("2020-10-01",formatter);
				toDate=LocalDate.parse("2020-10-31",formatter);
				break;
				
			case "november":
				fromDate=LocalDate.parse("2020-11-01",formatter);
				toDate=LocalDate.parse("2020-11-30",formatter);
				break;
				
			case "december":
				fromDate=LocalDate.parse("2020-12-01",formatter);
				toDate=LocalDate.parse("2020-12-31",formatter);
				break;
			default:
				throw new PortfolioException("Error while generating portfolio Report");
			}
		}
		
		te=transactionRepo.findAllByDateBetween(fromDate,toDate).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
		for(TransactionModel t: te)
		{
			if(t.getUserId()==userRepo.findByUserName(userName).getUserId()) {
				te1.add(t);
			}
		}
		return te1;
	}
	
	public List<InvestorAmountEarnedModel> getAmountEarnedforlast10Weeks(String userName)
	{
		List<InvestorAmountEarnedModel> list=new ArrayList<InvestorAmountEarnedModel>();
		InvestorAmountEarnedModel m=new InvestorAmountEarnedModel();
		LocalDate from=null,to=null;
		for(int i=0;i<10;i++)
		{
		to=LocalDate.now();
		from=to.minusDays(7);
		
		//m.setAmountEarned(investorAmountEarnedRepo.fin);
		
		}
		return list;
	}
	

}
