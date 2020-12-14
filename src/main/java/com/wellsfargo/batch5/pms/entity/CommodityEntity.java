package com.wellsfargo.batch5.pms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="commodities")
public class CommodityEntity {
	
	@Id
	@Column(name="commodity_code")
	private Integer commodityCode;
	
	
	@Column(name="commodity_name")
	private String commodityName;
	
	@Column(name="commodity_price")
	private Double currentPrice;
	
	@OneToMany(mappedBy="commodity")
	private Set<InvestorCommodityDetailsEntity> invCommodity;
	
	public CommodityEntity()
	{
		
	}
	
	public CommodityEntity(Integer commodityCode, String commodityName, Double currentPrice) {
		super();
		this.commodityCode = commodityCode;
		this.commodityName = commodityName;
		this.currentPrice = currentPrice;
	}

	public Integer getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(Integer commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	

}
