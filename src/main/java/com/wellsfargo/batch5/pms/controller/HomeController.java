package com.wellsfargo.batch5.pms.controller;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.InvestorRegisterModel;
import com.wellsfargo.batch5.pms.model.UserLoginModel;
import com.wellsfargo.batch5.pms.model.UserModel;
import com.wellsfargo.batch5.pms.security.UserDetailsServiceImpl;
import com.wellsfargo.batch5.pms.service.IHomeService;

@Controller
public class HomeController {
	
	@Autowired
	private IHomeService homeService;
	@Autowired
	private UserDetailsService userDetailsService; 
	
	@GetMapping({"","/","/home"})
	public ModelAndView homeAction()
	{
		ModelAndView mv=new ModelAndView("index","user",new InvestorRegisterModel());
		return mv;
	}
	
	@GetMapping("/login")
	public String loginAction()
	{
		return "login";
	}
	
	@PostMapping("/registration")
	public ModelAndView registerAction(@ModelAttribute("user") @Valid InvestorRegisterModel user, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		if(result.hasErrors()) {
		 mv= new ModelAndView("index","user",user);
		}
		else
		{
			homeService.register(user);
			mv = new ModelAndView("redirect:/login");
		}
		return mv;
		
	}
	
	@GetMapping("/user_home")
	 String userHomeAction() throws PortfolioException 
		{
		String view="login";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated())
		{
			Set<String> roles =auth.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());
			if(roles.contains("investor"))
			{
				view="redirect:/investor/investorhome";
			}
			else if(roles.contains("back_office_user"))
			{
				view="redirect:/backofficeuser/backOfficeUserHome";
			}
			else if(roles.contains("admin"))
			{
				view="redirect:/admin/adminHome";
			}
			else
			{
				throw new PortfolioException("Unidentified user role.Please contact Admin");
			}
		}
			return view;
		}
}
