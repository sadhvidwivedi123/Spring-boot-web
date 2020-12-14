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
	
	@Autowired
	private InvestorCommodityDetailsRepo investorCommodityRepo;
	
	@Override
	public Double getCurrentPortfolioValue(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		Integer userId=userRepo.findByUserName(userName).getUserId();
		Double currentPortfolioValue=0.0;
		
		/*if(investorCommodityDetailsRepo.existsByInvestor(investorRepo.findById(userId).get()))
		{
			List<InvestorCommodityDetailsModel> investorCommodityDetails=investorCommodityDetailsRepo.findAllByInvestor(userId).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
			for(InvestorCommodityDetailsModel l:investorCommodityDetails)
			{
				currentPortfolioValue=currentPortfolioValue+l.getQuantity()*commodityRepo.findById(l.getCommodity().getCommodityCode()).get().getCurrentPrice();
			}
			List<InvestorStockDetailsModel> investorStockDetails=investorStockDetailsRepo.findAllByInvestor(userId).stream().map(e->PortfolioParser.parse(e)).collect(Collectors.toList());
			for(InvestorStockDetailsModel l:investorStockDetails)
			{
				currentPortfolioValue=currentPortfolioValue+l.getUnit()*stockRepo.findById(l.getStock().getStockId()).get().getCurrentPrice();
			}
		}*/
		return currentPortfolioValue;
	}

	@Override
	public Double getAmountInvested(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAmountEarned(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getPortfolioWalletAmount(String userName) throws PortfolioException {
		// TODO Auto-generated method stub
		return null;
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
		
		List<InvestorStockDetailsEntity> entities= investorStockDetailsRepo.findAllByInvestor(userRepo.findByUserName(auth.getName()).getUserId());
		 
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
		InvestorCommodityDetailsEntity invComDetails= investorCommodityDetailsRepo.findById(commodityRepo.findByCommodityName(commodityName).getCommodityCode()).get();
		if(invComDetails.getUnit()-quantity==0){
		investorCommodityDetailsRepo.deleteById(invComDetails.getInvestorCommKey());	
		}
		else
		{
		invComDetails.setUnit(invComDetails.getUnit()-quantity);
		Integer key= invComDetails.getInvestorCommKey();
		quantity= invComDetails.getUnit()-quantity;
		LocalDate date= LocalDate.now();
		investorCommodityRepo.update(quantity,key,date);
		}
		
	}
	
	

}
