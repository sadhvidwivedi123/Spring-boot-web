package com.wellsfargo.batch5.pms.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="stocks")
public class StockEntity {
	
	@Id
	@GeneratedValue
	@Column(name="stock_id")
	private Integer stockId;
	
	@Column(name="stock_Exchange")
	private String stockExchange;
	
	@Column(name="current_price")
	private Double currentPrice;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="time")
	private LocalTime time;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="company_code")
	private CompanyEntity company;
	
	@OneToMany(mappedBy="stock")
	private Set<InvestorStockDetailsEntity> invStock;
	
	public StockEntity()
	{
		
	}
	public StockEntity( String stockExchange, Double currentPrice, LocalDate date, LocalTime time,
			Integer companyId) {
		super();
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	
	

	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
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
	
	public CompanyEntity getCompany() {
		return company;
	}
	public void setCompany(CompanyEntity company) {
		this.company = company;
	}
	
	

}
