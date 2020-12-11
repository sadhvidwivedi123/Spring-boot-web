package com.wellsfargo.batch5.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StockModel {
	
	private Integer stockId;
	
	@NotNull(message="Stock Exchange cannot be null")
	@NotBlank(message="Stock Exchange cannot be blank")
	private String stockExchange;
	
	@DecimalMin(value="0", message="Current Price cannot be less than 0")
	private Double currentPrice;
	
	@NotNull(message="Date cannot be null")
	private LocalDate date;
	
	@NotNull(message="Time cannot be null")
	private LocalTime time;
	
	@NotNull(message="Company cannot be null")
	private CompanyModel company;

	private Set<InvestorStockDetailsModel> invStock;
	
	public StockModel()
	{
		
	}
	public StockModel( String stockExchange, Double currentPrice, LocalDate date, LocalTime time,
			Integer stockId) {
		super();
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
		this.stockId = stockId;
	}

	/*public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}*/
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	
	

}
