package com.wellsfargo.batch5.pms.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.InvestorModel;
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
			mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
			if(investorService.getInvestorCommodityList().size()!=0)
			mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
			//mv.addObject("inv_stock_list",investorService.getInvestorStockList());
		}
		
		return mv;
	}
	@PostMapping("/buyStocks")
	public ModelAndView goToBuyStocks() throws PortfolioException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv=new ModelAndView("/investor/buyStocks");
		
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
	public ModelAndView goToBuyOrderConfirmation(@RequestParam("quantity") String quantity,@ModelAttribute("commodity") CommodityModel commodity) throws PortfolioException
	{
		
		ModelAndView mv=new ModelAndView("/investor/orderConfirmation");
		mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityName(commodity.getCommodityName()));
		mv.addObject("buy",true);
		mv.addObject("isStock",true);
		mv.addObject("quantity", quantity);
		return mv;
	}
	
	@PostMapping("/orderConfirmationSellCommodity")
	public ModelAndView goToSellOrderConfirmation(@RequestParam("quantity")  String quantity,@RequestParam("isSelected")  String isSelected,@ModelAttribute("commodity") CommodityModel commodity) throws PortfolioException
	{
		
		ModelAndView mv=new ModelAndView("/investor/orderConfirmation");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
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
		mv.addObject("company_list",backOfficeUserService.getCompanyList());
		mv.addObject("currentPortfolioValue",investorService.getCurrentPortfolioValue(auth.getName()));
		mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
		if(investorService.getInvestorCommodityList().size()!=0)
		mv.addObject("inv_commodity_list",investorService.getInvestorCommodityList());
		}
		return mv;
	}
}
