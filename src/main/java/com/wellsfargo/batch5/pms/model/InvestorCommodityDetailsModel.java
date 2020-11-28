package com.wellsfargo.batch5.pms.model;


import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class InvestorCommodityDetailsModel{
	
	private Integer investorCommKey;

	@NotNull(message="Investor cannot be null")
	@NotBlank(message="Investor cannot be blank")
	private InvestorModel investor;

	@NotNull(message="Commodity cannot be null")
	@NotBlank(message="Commodity cannot be blank")
	private CommodityModel commodity;
	
	@NotNull(message="Unit cannot be null")
	@NotBlank(message="Unit  cannot be blank")
	private Integer unit;
	
	@NotNull(message="Date cannot be null")
	private LocalDate date;

	public Integer getInvestorCommKey() {
		return investorCommKey;
	}

	public InvestorCommodityDetailsModel()
	{
		
	}
	public InvestorCommodityDetailsModel(Integer investorCommKey, InvestorModel investor, CommodityModel commodity, Integer unit,
			LocalDate date) {
		super();
		this.investorCommKey = investorCommKey;
		this.investor = investor;
		this.commodity = commodity;
		this.unit = unit;
		this.date = date;
	}
	
	
	public void setInvestorCommKey(Integer investorCommKey) {
		this.investorCommKey = investorCommKey;
	}

	public InvestorModel getInvestor() {
		return investor;
	}

	public void setInvestor(InvestorModel investor) {
		this.investor = investor;
	}

	public CommodityModel getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityModel commodity) {
		this.commodity = commodity;
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
