package com.wellsfargo.batch5.pms.model;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CommodityModel {
	
	@Min(value=1,message="Commodity code cannot be less than 1")
	private Integer commodityCode;
	
	@NotNull(message="Commodity name cannot be null")
	@NotBlank(message="Commodity name cannot be blank")
	@Size(min=3,max=30, message="Commodity name length should be between 4 to 30 characters")
	private String commodityName;
	
	@DecimalMin(value="0.1", message="Commodity price cannot be less than 0.1")
	private Double currentPrice;
	
	//private Set<InvestorCommodityDetails> invCommodity;
	
	public CommodityModel()
	{
		
	}
	
	public CommodityModel(Integer commodityCode, String commodityName, Double currentPrice) {
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
