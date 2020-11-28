package com.wellsfargo.batch5.pms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class CompanyEntity {
	
	
	@Id
	@Column(name="company_code")
	private Integer companyCode;
	
	@Column(name="company_title")
	private String companyTitle;
	
	@Column(name="operations")
	private String operations;
	
	@Column(name="share_count")
	private Integer shareCount;
	
	@Column(name="open_share_price")
	private Double openSharePrice;
	
	@Column(name="sector")
	private String sector;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="turnover")
	private Double turnOver;
	
	@OneToOne(mappedBy = "company")
	private StockEntity stock;
	
	public CompanyEntity()
	{
		
	}

	public CompanyEntity(Integer companyCode, String companyTitle, String operations, Integer shareCount,
			Double openSharePrice, String sector, String currency, Double turnOver, StockEntity stock) {
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

	public StockEntity getStock() {
		return stock;
	}

	public void setStock(StockEntity stock) {
		this.stock = stock;
	}
	
	
}