package com.wellsfargo.batch5.pms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceModeImportSelector;
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
import com.wellsfargo.batch5.pms.model.BackOfficeUserModel;
import com.wellsfargo.batch5.pms.model.InvestorModel;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/createBackOfficeUser")
	public ModelAndView addBackOfficeUserAction(@ModelAttribute("bouser") @Valid UserModel bouser, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
			mv = new ModelAndView("/admin/adminHome","bouser",bouser);
		}
		else
		{
			adminService.addbackOfficeUser(bouser);
			mv = new ModelAndView("/admin/adminHome","bouser",new UserModel());
			mv.addObject("user_name",bouser.getName());
			
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		return mv;
		
	}
	
	@GetMapping("/adminHome")
	public ModelAndView loginAction()
	{
		ModelAndView mv = new ModelAndView("/admin/adminHome","bouser",new UserModel());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			mv.addObject("auth",auth);
		}
		return mv;
	}
	

}
