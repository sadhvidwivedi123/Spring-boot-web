package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompanyModel {
	
	@NotNull(message="Company code cannot be null")
	@NotBlank(message="Company code cannot be blank")
	@Min(value=1,message="Company code cannot be less than 1")
	private Integer companyCode;
	
	@NotNull(message="Company Title cannot be null")
	@NotBlank(message="Company Title cannot be blank")
	@Size(min=3,max=30, message="Company Title length should be between 4 to 30 characters")
	private String companyTitle;
	
	@NotNull(message="Company Operations cannot be null")
	@NotBlank(message="Company Operations cannot be blank")
	@Size(min=3,max=30, message="Company Operations length should be between 4 to 30 characters")
	private String operations;
	
	@NotNull(message="Share count cannot be null")
	@NotBlank(message="Share count cannot be blank")
	@Min(value=1,message="Share count cannot be less than 1")
	private Integer shareCount;
	
	@NotNull(message="Open Share price cannot be null")
	@NotBlank(message="Open Share price cannot be blank")
	@DecimalMin(value="0.1", message="Open Share price cannot be less than 0.1")
	private Double openSharePrice;
	
	@NotNull(message="Sector cannot be null")
	@NotBlank(message="Sector cannot be blank")
	@Size(min=3,max=30, message="Sector length should be between 4 to 30 characters")
	private String sector;
	
	@NotNull(message="Currency cannot be null")
	@NotBlank(message="Currency cannot be blank")
	private String currency;
	
	@NotNull(message="Turn-over cannot be null")
	@NotBlank(message="Turn-over cannot be blank")
	@DecimalMin(value="0.1", message="Turn-over cannot be less than 0.1")
	private Double turnOver;
	
	@NotNull(message="Stock cannot be null")
	private StockModel stock;
	
	public CompanyModel()
	{
		
	}

	public CompanyModel(Integer companyCode, String companyTitle, String operations, Integer shareCount,
			Double openSharePrice, String sector, String currency, Double turnOver, StockModel stock) {
		super();
		this.companyCode = companyCode;
		this.companyTitle = companyTitle;
		this.operations = operations;
		this.shareCount = shareCount;
		this.openSharePrice = openSharePrice;
		this.sector = sector;
		this.currency = currency;
		this.turnOver = turnOver;
		this.stock = stock;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyTitle() {
		return companyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	public String getOperations() {
		return operations;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Double getOpenSharePrice() {
		return openSharePrice;
	}

	public void setOpenSharePrice(Double openSharePrice) {
		this.openSharePrice = openSharePrice;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(Double turnOver) {
		this.turnOver = turnOver;
	}

	public StockModel getStock() {
		return stock;
	}

	public void setStock(StockModel stock) {
		this.stock = stock;
	}
	
	
}