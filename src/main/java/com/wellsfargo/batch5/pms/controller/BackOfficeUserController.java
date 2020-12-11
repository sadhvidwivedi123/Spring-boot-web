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
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.repo.BackOfficeUserRepo;
import com.wellsfargo.batch5.pms.service.IBackOfficeUserService;

@Controller
@RequestMapping("/backofficeuser")
public class BackOfficeUserController {
	
	@Autowired
	private IBackOfficeUserService backOfficeUserService;

	@GetMapping("/backOfficeUserHome")
	public ModelAndView loginAction()
	{
		ModelAndView mv=new ModelAndView("/backofficeuser/backOfficeUserHome","","");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		return mv;
	}
	@GetMapping("/createCompanyIPO")
	public ModelAndView gotoCompanyIPO()
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
			}
			
		}
		
		return mv;
		
	}
	@GetMapping("/createStock")
	public ModelAndView gotoStock()
	{
		ModelAndView mv=new ModelAndView("/backofficeuser/addCompanyIPO","company",new CompanyModel());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		return mv;
	}
	@PostMapping("/createStock")
	public ModelAndView createStock(@ModelAttribute("company") @Valid CompanyModel company, BindingResult result) throws PortfolioException {
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
			}
			
		}
		
		return mv;
		
	}
	
}
