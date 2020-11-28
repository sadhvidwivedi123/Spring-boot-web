package com.wellsfargo.batch5.pms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class InvestorStockDetailsModel {

	private Integer investorStockId;
	
	@NotNull(message="Investor cannot be null")
	@NotBlank(message="Investor cannot be blank")
	private InvestorModel investor;

	@NotNull(message="Commodity cannot be null")
	@NotBlank(message="Commodity cannot be blank")
	private StockModel stock;
	
	@NotNull(message="Unit cannot be null")
	@NotBlank(message="Unit  cannot be blank")
	private Integer unit;
	
	@NotNull(message="Date cannot be null")
	private LocalDate date;

	public InvestorStockDetailsModel(Integer investorStockId, InvestorModel investor, StockModel stock, Integer unit, LocalDate date) {
		super();
		this.investorStockId = investorStockId;
		this.investor = investor;
		this.stock = stock;
		this.unit = unit;
		this.date = date;
	}

	public Integer getInvestorStockId() {
		return investorStockId;
	}

	public void setInvestorStockId(Integer investorStockId) {
		this.investorStockId = investorStockId;
	}

	public InvestorModel getInvestor() {
		return investor;
	}

	public void setInvestor(InvestorModel investor) {
		this.investor = investor;
	}

	public StockModel getStock() {
		return stock;
	}

	public void setStock(StockModel stock) {
		this.stock = stock;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
