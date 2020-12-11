package com.wellsfargo.batch5.pms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;



@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(PortfolioException.class)
	public ModelAndView libraryExceptionAction(PortfolioException exp) {
		return new ModelAndView("error-page","errMsg",exp.getMessage());
	}
}
