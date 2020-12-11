package com.wellsfargo.batch5.pms.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.InvestorModel;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@PostMapping("/create_backOfficeUser")
	public ModelAndView addBookAction(@ModelAttribute("user") @Valid InvestorModel book, BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		
		return mv;
		
	}

}
