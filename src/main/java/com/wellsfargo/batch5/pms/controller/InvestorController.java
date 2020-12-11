package com.wellsfargo.batch5.pms.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.InvestorModel;

@Controller
@RequestMapping("/investor")
public class InvestorController {
	
	@GetMapping("/investorhome")
	public String loginAction()
	{
		return "/investor/investorhome";
	}
	

}
