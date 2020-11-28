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
@Table(name="investor_commodity_details")
public class InvestorCommodityDetailsEntity{
	
	@GeneratedValue
	@Id
	@Column(name="inv_comm_id")
	private Integer investorCommKey;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private InvestorEntity investor;
	
	@ManyToOne
	@JoinColumn(name="commodity_code")
	private CommodityEntity commodity;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="date")
	private LocalDate date;

	public Integer getInvestorCommKey() {
		return investorCommKey;
	}

	public InvestorCommodityDetailsEntity()
	{
		
	}
	public InvestorCommodityDetailsEntity(Integer investorCommKey, InvestorEntity investor, CommodityEntity commodity, Integer unit,
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

	public InvestorEntity getInvestor() {
		return investor;
	}

	public void setInvestor(InvestorEntity investor) {
		this.investor = investor;
	}

	public CommodityEntity getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityEntity commodity) {
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
