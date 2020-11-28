package com.wellsfargo.batch5.pms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="investor_stock_details")
public class InvestorStockDetailsEntity {
	
	@GeneratedValue
	@Id
	@Column(name="inv_stock_id")
	private Integer investorStockId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private InvestorEntity investor;
	
	@ManyToOne
	@JoinColumn(name="stock_id")
	private StockEntity stock;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="date")
	private LocalDate date;

	public InvestorStockDetailsEntity(Integer investorStockId, InvestorEntity investor, StockEntity stock, Integer unit, LocalDate date) {
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

	public InvestorEntity getInvestor() {
		return investor;
	}

	public void setInvestor(InvestorEntity investor) {
		this.investor = investor;
	}

	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
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
