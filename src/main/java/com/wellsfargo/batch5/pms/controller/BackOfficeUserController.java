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
import com.wellsfargo.batch5.pms.model.CommisionModel;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.StockModel;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.repo.BackOfficeUserRepo;
import com.wellsfargo.batch5.pms.repo.CompanyRepo;
import com.wellsfargo.batch5.pms.service.IBackOfficeUserService;

@Controller
@RequestMapping("/backofficeuser")
public class BackOfficeUserController {
	
	@Autowired
	private IBackOfficeUserService backOfficeUserService;

	@GetMapping("/backOfficeUserHome")
	public ModelAndView loginAction() throws PortfolioException
	{
		ModelAndView mv=new ModelAndView("/backofficeuser/backOfficeUserHome","","");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
			mv.addObject("company_list",backOfficeUserService.getCompanyList());
			mv.addObject("stock_list",backOfficeUserService.getStockList());
			mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
		}
		return mv;
	}
	@GetMapping("/createCompanyIPO")
	public ModelAndView gotoCompanyIPO() throws PortfolioException
	{
		ModelAndView mv=new ModelAndView("/backofficeuser/addCompanyIPO","company",new CompanyModel());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		return mv;
	}
	@PostMapping("/createCompanyIPO")
	public ModelAndView createCompanyIPO(@ModelAttribute("company") @Valid CompanyModel company, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/backofficeuser/addCompanyIPO","company",company);
		}
		else
		{
			backOfficeUserService.addCompany(company);
			mv = new ModelAndView("/backofficeuser/backOfficeUserHome","company",new CompanyModel());
			mv.addObject("company_name",company.getCompanyTitle());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
				mv.addObject("company_list",backOfficeUserService.getCompanyList());
			}
			
		}
		
		return mv;
		
	}
	
	
	@GetMapping("/createStock")
	public ModelAndView gotoStock()
	{
		ModelAndView mv=new ModelAndView("/backofficeuser/addStock","stock",new StockModel());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		return mv;
	}
	
	@PostMapping("/createStock")
	public ModelAndView createStock(@ModelAttribute("stock") @Valid StockModel stock, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/backofficeuser/addStock","stock",stock);
		}
		else
		{
			stock=backOfficeUserService.addStock(stock);
			mv = new ModelAndView("/backofficeuser/backOfficeUserHome","stock",new StockModel());
			mv.addObject("stock",stock.getCompany().getCompanyTitle());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
				mv.addObject("company_list",backOfficeUserService.getCompanyList());
				mv.addObject("stock_list",backOfficeUserService.getStockList());
				mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
			}
			
		}
		
		return mv;
		
	}
	@GetMapping("/createCommodity")
	public ModelAndView gotoCommodity()
	{
		ModelAndView mv=new ModelAndView("/backofficeuser/addCommodity","commodity",new CommodityModel());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		
		return mv;
	}
	
	@PostMapping("/createCommodity")
	public ModelAndView createCommodity(@ModelAttribute("commodity") @Valid CommodityModel commodity, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/backofficeuser/addCommodity","commodity",commodity);
		}
		else
		{
			commodity=backOfficeUserService.addCommodity(commodity);
			mv = new ModelAndView("/backofficeuser/backOfficeUserHome","commodity",new CommodityModel());
			mv.addObject("commodity",commodity.getCommodityName());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
				mv.addObject("company_list",backOfficeUserService.getCompanyList());
				mv.addObject("stock_list",backOfficeUserService.getStockList());
				mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
			}
			
		}
		
		return mv;
		
	}
	@PostMapping("/modifyStockAction")
	public ModelAndView modifyStockAction(@ModelAttribute("stock") @Valid StockModel stock, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/backofficeuser/modifyStock","stock",stock);
		}
		else
		{
			stock=backOfficeUserService.modifyStock(stock);
			mv = new ModelAndView("/backofficeuser/backOfficeUserHome","stock",new StockModel());
			mv.addObject("stock",stock.getCompany().getCompanyTitle());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
				mv.addObject("company_list",backOfficeUserService.getCompanyList());
				mv.addObject("stock_list",backOfficeUserService.getStockList());
				mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
				mv.addObject("isUpdated", true);
			}
			
		}
		
		return mv;
		
	}
	@PostMapping("/modifyStock")
	public ModelAndView modifyStock(@RequestParam("stock") String selectedStock) throws PortfolioException {
		ModelAndView mv=null;
		
			mv = new ModelAndView("/backofficeuser/modifyStock");
			mv.addObject("stock",backOfficeUserService.getStockByCompanyCode(Integer.parseInt(selectedStock)));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
			}
			
		
		
		return mv;
		
	}
	@PostMapping("/modifyCommodityAction")
	public ModelAndView modifyCommodityAction(@ModelAttribute("commodity") @Valid CommodityModel commodity, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/backofficeuser/modifyCommodity","commodity",commodity);
		}
		else
		{
			commodity=backOfficeUserService.modifyCommodity(commodity);
			mv = new ModelAndView("/backofficeuser/backOfficeUserHome","commodity",new CommodityModel());
			mv.addObject("commodity",commodity.getCommodityName());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
				mv.addObject("company_list",backOfficeUserService.getCompanyList());
				mv.addObject("stock_list",backOfficeUserService.getStockList());
				mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
				mv.addObject("isUpdated", true);
			}
			
		}
		
		return mv;
		
	}
	@PostMapping("/modifyCommodity")
	public ModelAndView modifyCommodity(@RequestParam("commodity") String selectedCommodity) throws PortfolioException {
		ModelAndView mv=null;
		
			mv = new ModelAndView("/backofficeuser/modifyCommodity","select",selectedCommodity);
			mv.addObject("commodity",backOfficeUserService.getCommodityByCommodityCode(Integer.parseInt(selectedCommodity)));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
			}
			
		
		
		return mv;
		
	}
	@PostMapping("/modifyCompanyAction")
	public ModelAndView modifyCompanyAction(@ModelAttribute("company") @Valid CompanyModel company, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/backofficeuser/modifyCompanyAction","company",company);
		}
		else
		{
			company=backOfficeUserService.modifyCompany(company);
			mv = new ModelAndView("/backofficeuser/backOfficeUserHome","company",new CompanyModel());
			mv.addObject("company",company.getCompanyTitle());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
				mv.addObject("company_list",backOfficeUserService.getCompanyList());
				mv.addObject("stock_list",backOfficeUserService.getStockList());
				mv.addObject("commodity_list",backOfficeUserService.getCommodityList());
				mv.addObject("isUpdated", true);
			}
			
		}
		
		return mv;
		
	}
	@PostMapping("/modifyCompany")
	public ModelAndView modifyCompany(@RequestParam("company") String selectedCompany) throws PortfolioException {
		ModelAndView mv=null;
		
			mv = new ModelAndView("/backofficeuser/modifyCompanyDetails");
			mv.addObject("company",backOfficeUserService.getCompanyByCompanyCode(Integer.parseInt(selectedCompany)));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
				mv.addObject("auth",auth);
			}
			
		
		
		return mv;
		
	}
}
