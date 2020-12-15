package com.wellsfargo.batch5.pms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.InvestorModel;
import com.wellsfargo.batch5.pms.model.StockModel;
import com.wellsfargo.batch5.pms.repo.InvestorCommodityDetailsRepo;
import com.wellsfargo.batch5.pms.service.IBackOfficeUserService;
import com.wellsfargo.batch5.pms.service.IInvestorService;


@Controller
@RequestMapping("/investor")
public class InvestorController {
	
	@Autowired
	private IInvestorService investorService;
	
	@Autowired
	private IBackOfficeUserService backOfficeUserService;
	
	@GetMapping("/investorhome")
	public ModelAndView loginAction() throws PortfolioException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv=new ModelAndView("/investor/investorhome");
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
			mv.addObject("company_list",backOfficeUserService.getCompanyList());
			mv.addObject("currentPortfolioValue",investorService.getCurrentPortfolioValue(auth.getName()));
			mv.addObject("amountInvested",investorService.getAmountInvested(auth.getName()));
			mv.addObject("amountEarned",investorService.getAmountEarned(auth.getName()));
			mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
			mv.addObject("stock_list",backOfficeUserService.getStockList());
			if(investorService.getInvestorCommodityList()!=null)
			if(investorService.getInvestorCommodityList().size()!=0)
				mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
			if(investorService.getInvestorStockList()!=null)
			if(investorService.getInvestorStockList().size()!=0)
				mv.addObject("inv_stock_list",investorService.getInvestorStockList());
			mv.addObject("walletBalance", investorService.getPortfolioWalletAmount(auth.getName()));
			//mv.addObject("inv_stock_list",investorService.getInvestorStockList());
		}
		
		return mv;
	}
	@PostMapping("/buyStocks")
	public ModelAndView goToBuyStocks(@RequestParam("stock") String selectedStock) throws PortfolioException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv=new ModelAndView("/investor/buyStocks","select",selectedStock);
		mv.addObject("stock",backOfficeUserService.getStockByCompanyCode(Integer.parseInt(selectedStock)));
		
		return mv;
	}
	@PostMapping("/sellStocks")
	public ModelAndView goToSellStocks() throws PortfolioException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv=new ModelAndView("/investor/sellStocks");
		
		return mv;
	}
	@PostMapping("/buyCommodity")
	public ModelAndView goToBuyCommodity(@RequestParam("commodity") String selectedCommodity) throws PortfolioException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv=new ModelAndView("/investor/buyCommodity","select",selectedCommodity);
		mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(selectedCommodity)));
		
		return mv;
	}
	@PostMapping("/sellCommodity")
	public ModelAndView goTosellCommodity(@RequestParam("commodity") String selectedCommodity) throws PortfolioException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv=new ModelAndView("/investor/sellCommodity","select",selectedCommodity);
		mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(selectedCommodity)));
		
		return mv;
	}
	
	@PostMapping("/orderConfirmationBuyCommodity")
	public ModelAndView goToCommodityBuyOrderConfirmation(@RequestParam("quantity") String quantity,@RequestParam("commodityCode") String commodityCode) throws PortfolioException
	{
		ModelAndView mv=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CommodityModel cm=backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(commodityCode));
		if(investorService.hasSufficientWalletBalance(auth.getName(), Integer.parseInt(quantity)*cm.getCurrentPrice()))
		{
		mv=new ModelAndView("/investor/orderConfirmation");
		mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(commodityCode)));
		mv.addObject("buy",true);
		mv.addObject("isStock",false);
		mv.addObject("quantity", quantity);
		}
		else
		{
			mv=new ModelAndView("/investor/buyCommodity");
			mv.addObject("insufficientAmount",true);
			mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(commodityCode)));
		}
		return mv;
	}
	
	@PostMapping("/orderConfirmationSellCommodity")
	public ModelAndView goToCommoditySellOrderConfirmation(@RequestParam("quantity")  String quantity,@RequestParam("isSelected")  String isSelected,@ModelAttribute("commodity") CommodityModel commodity) throws PortfolioException
	{
		
		ModelAndView mv=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			
				mv=new ModelAndView("/investor/orderConfirmation");
				mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(isSelected)));
				mv.addObject("buy",false);
				mv.addObject("isStock",false);
				mv.addObject("quantity", quantity);
				mv.addObject("auth",auth);
			
		
		}
		return mv;
	}
	@PostMapping("/sellCommodityConfirm")
	public ModelAndView sellCommodity(@RequestParam("commodityName")  String commodityName,@RequestParam("currentPrice")  String currentPrice,@RequestParam("quantity")  String quantity,@RequestParam("totalPrice")  String totalPrice) throws PortfolioException
	{
		ModelAndView mv=new ModelAndView("/investor/investorhome");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			
				
		investorService.sellCommodity(auth.getName(),commodityName,Double.parseDouble(currentPrice),Integer.parseInt(quantity),Double.parseDouble(totalPrice));
		mv.addObject("auth",auth);
		mv.addObject("isCommoditySold",true);
		mv.addObject("soldCommodity",commodityName);
		mv.addObject("soldQuantity",quantity);
		mv.addObject("company_list",backOfficeUserService.getCompanyList());
		mv.addObject("currentPortfolioValue",investorService.getCurrentPortfolioValue(auth.getName()));
		mv.addObject("amountInvested",investorService.getAmountInvested(auth.getName()));
		mv.addObject("amountEarned",investorService.getAmountEarned(auth.getName()));
		mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
		mv.addObject("walletBalance", investorService.getPortfolioWalletAmount(auth.getName()));
		if(investorService.getInvestorCommodityList().size()!=0)
		mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
		if(investorService.getInvestorStockList().size()!=0)
			mv.addObject("inv_stock_list",investorService.getInvestorStockList());
		}
		return mv;
	}
	@PostMapping("/buyCommodityConfirm")
	public ModelAndView buyCommodity(@RequestParam("commodityName")  String commodityName,@RequestParam("currentPrice")  String currentPrice,@RequestParam("quantity")  String quantity,@RequestParam("totalPrice")  String totalPrice) throws PortfolioException
	{
		ModelAndView mv=new ModelAndView("/investor/investorhome");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
		investorService.buyCommodity(auth.getName(),commodityName,Double.parseDouble(currentPrice),Integer.parseInt(quantity),Double.parseDouble(totalPrice));
		mv.addObject("auth",auth);
		mv.addObject("isCommodityBought",true);
		mv.addObject("boughtCommodity",commodityName);
		mv.addObject("boughtQuantity",quantity);
		mv.addObject("company_list",backOfficeUserService.getCompanyList());
		mv.addObject("currentPortfolioValue",investorService.getCurrentPortfolioValue(auth.getName()));
		mv.addObject("amountInvested",investorService.getAmountInvested(auth.getName()));
		mv.addObject("amountEarned",investorService.getAmountEarned(auth.getName()));
		mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
		mv.addObject("stock_list",backOfficeUserService.getStockList());
		mv.addObject("walletBalance", investorService.getPortfolioWalletAmount(auth.getName()));
		if(investorService.getInvestorCommodityList().size()!=0)
		mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
		if(investorService.getInvestorStockList().size()!=0)
			mv.addObject("inv_stock_list",investorService.getInvestorStockList());
		}
		
		return mv;
	}
	
	
	
	@PostMapping("/orderConfirmationBuyStock")
	public ModelAndView goToStockBuyOrderConfirmation(@RequestParam("quantity") String quantity,@RequestParam("companyCode") String companyCode) throws PortfolioException
	{
		ModelAndView mv=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		StockModel cm=backOfficeUserService.getStockByCompanyCode(Integer.parseInt(companyCode));
		if(investorService.hasSufficientWalletBalance(auth.getName(), Integer.parseInt(quantity)*cm.getCurrentPrice()))
		{
		mv=new ModelAndView("/investor/orderConfirmation");
		mv.addObject("stock",backOfficeUserService.getStockByCompanyCode(Integer.parseInt(companyCode)));
		mv.addObject("buy",true);
		mv.addObject("isStock",true);
		mv.addObject("quantity", quantity);
		}
		else
		{
			mv=new ModelAndView("/investor/buyStocks");
			mv.addObject("insufficientAmount",true);
			mv.addObject("stock",backOfficeUserService.getStockByCompanyCode(Integer.parseInt(companyCode)));
		}
		return mv;
	}
	
	
	@PostMapping("/buyStockConfirm")
	public ModelAndView buyStocks(@RequestParam("stockId")  String stockId,@RequestParam("currentPrice")  String currentPrice,@RequestParam("quantity")  String quantity,@RequestParam("totalPrice")  String totalPrice) throws PortfolioException
	{
		ModelAndView mv=new ModelAndView("/investor/investorhome");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
		investorService.buyStock(auth.getName(), Integer.parseInt(stockId), Double.parseDouble(currentPrice), Integer.parseInt(quantity), Double.parseDouble(totalPrice));
		mv.addObject("auth",auth);
		mv.addObject("isStockBought",true);
		mv.addObject("boughtStock",stockId);
		mv.addObject("boughtQuantity",quantity);
		mv.addObject("company_list",backOfficeUserService.getCompanyList());
		mv.addObject("currentPortfolioValue",investorService.getCurrentPortfolioValue(auth.getName()));
		mv.addObject("amountInvested",investorService.getAmountInvested(auth.getName()));
		mv.addObject("amountEarned",investorService.getAmountEarned(auth.getName()));
		mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
		mv.addObject("walletBalance", investorService.getPortfolioWalletAmount(auth.getName()));
		mv.addObject("stock_list",backOfficeUserService.getStockList());
		if(investorService.getInvestorCommodityList().size()!=0)
		mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
		if(investorService.getInvestorStockList().size()!=0)
			mv.addObject("inv_stock_list",investorService.getInvestorStockList());
			}
		return mv;
	}
	
	
	
	@PostMapping("/orderConfirmationSellStock")
	public ModelAndView goToStockSellOrderConfirmation(@RequestParam("quantity") String quantity,@RequestParam("companyCode") String companyCode) throws PortfolioException
	{
		ModelAndView mv=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		StockModel cm=backOfficeUserService.getStockByCompanyCode(Integer.parseInt(companyCode));
		mv=new ModelAndView("/investor/orderConfirmation");
		mv.addObject("stock",backOfficeUserService.getStockByCompanyCode(Integer.parseInt(companyCode)));
		mv.addObject("buy",false);
		mv.addObject("isStock",true);
		mv.addObject("quantity", quantity);
		
		return mv;
	}
	
	@PostMapping("/sellStockConfirm")
	public ModelAndView sellStocks(@RequestParam("stockId")  String stockId,@RequestParam("currentPrice")  String currentPrice,@RequestParam("quantity")  String quantity,@RequestParam("totalPrice")  String totalPrice) throws PortfolioException
	{
		ModelAndView mv=new ModelAndView("/investor/investorhome");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
		investorService.sellStock(auth.getName(), stockId, Double.parseDouble(currentPrice), Integer.parseInt(quantity), Double.parseDouble(totalPrice));
		mv.addObject("auth",auth);
		mv.addObject("isStockSold",true);
		mv.addObject("soldStock",stockId);
		mv.addObject("soldQuantity",quantity);
		mv.addObject("company_list",backOfficeUserService.getCompanyList());
		mv.addObject("currentPortfolioValue",investorService.getCurrentPortfolioValue(auth.getName()));
		mv.addObject("amountInvested",investorService.getAmountInvested(auth.getName()));
		mv.addObject("amountEarned",investorService.getAmountEarned(auth.getName()));
		mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
		mv.addObject("walletBalance", investorService.getPortfolioWalletAmount(auth.getName()));
		mv.addObject("stock_list",backOfficeUserService.getStockList());
		if(investorService.getInvestorCommodityList().size()!=0)
		mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
		if(investorService.getInvestorStockList().size()!=0)
			mv.addObject("inv_stock_list",investorService.getInvestorStockList());
			}
		return mv;
	}
	
	@GetMapping(value = "/get_company_list")
    public @ResponseBody List getTagList(@RequestParam("companyText") String companyText) {
        List tagList = investorService.getCompanyListBasedOnText(companyText);
        return tagList;
    }
	
}
