package com.wellsfargo.batch5.pms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.entity.CommisionEntity;
import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.InvestorCommodityDetailsEntity;
import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.InvestorStockDetailsEntity;
import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommisionModel;
import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;
import com.wellsfargo.batch5.pms.model.InvestorStockDetailsModel;
import com.wellsfargo.batch5.pms.repo.CommisionRepo;
import com.wellsfargo.batch5.pms.repo.CommodityRepo;
import com.wellsfargo.batch5.pms.repo.InvestorCommodityDetailsRepo;
import com.wellsfargo.batch5.pms.repo.InvestorRepo;
import com.wellsfargo.batch5.pms.repo.InvestorStockDetailsRepo;
import com.wellsfargo.batch5.pms.repo.StockRepo;
import com.wellsfargo.batch5.pms.repo.UserRepo;
import com.wellsfargo.batch5.pms.util.PortfolioParser;

@Service
public class InvestorServiceImpl implements IInvestorService{

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

	@Override
	public Double getCurrentPortfolioValue(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		Integer userId=userRepo.findByUserName(userName).getUserId();
		Double currentPortfolioValue=0.0;
		
		if(investorCommodityDetailsRepo.existsByInvestor(investorRepo.findById(userId).get()))
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
		return investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get().getAmountInvested();
	}

	@Override
	public Double getAmountEarned(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		Double amountEarned=0.0;
		InvestorEntity investor=investorRepo.findById(userRepo.findByUserName(userName).getUserId()).get();
		if(investor.getAmountInvested()==null&&investor.getCurrentPortfolioValue()==null || investor.getCurrentPortfolioValue()-investor.getAmountInvested()<0)
			amountEarned=0.0;
		else
			amountEarned=investor.getCurrentPortfolioValue()-investor.getAmountInvested();
			
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
		InvestorCommodityDetailsEntity invComDetails= investorCommodityDetailsRepo.findByCommodity(commodityRepo.findByCommodityName(commodityName));
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
			if(investorCommodityDetailsRepo.existsByCommodity(commodityRepo.findByCommodityName(commodityName)))
			{
			InvestorCommodityDetailsEntity invComDetails= investorCommodityDetailsRepo.findByCommodity(commodityRepo.findByCommodityName(commodityName));
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
			InvestorStockDetailsEntity invStockDetails= investorStockDetailsRepo.findByStock(stockRepo.findByStockId(Integer.parseInt(stockId)));
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
					if(investorStockDetailsRepo.existsByStock(stockRepo.findByStockId(stockId)))
					{
					InvestorStockDetailsEntity invStockDetails= investorStockDetailsRepo.findByStock(stockRepo.findByStockId(stockId));
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
		
	}

	@Override
	public List getCompanyListBasedOnText(String companyText) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
