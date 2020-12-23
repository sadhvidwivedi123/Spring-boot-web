package com.wellsfargo.batch5.pms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class TransactionModel {
	
	private Integer transactionId;
	
	private Integer userId;
	//buy or sell
	private String transactionType;
	
	private String stockCommodity;
	
	private Double amount;
	
	private LocalDate date;
	
	private String companyName;
	
	private String commodityName;
	
	private Integer quantity;
	
	public TransactionModel()
	{
		
	}

	public TransactionModel(Integer transactionId, Integer userId, String transactionType, String stockCommodity,
			Double amount, LocalDate date, String companyName, String commodityName, Integer quantity) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionType = transactionType;
		this.stockCommodity = stockCommodity;
		this.amount = amount;
		this.date = date;
		this.companyName = companyName;
		this.commodityName = commodityName;
		this.quantity = quantity;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStockCommodity() {
		return stockCommodity;
	}

	public void setStockCommodity(String stockCommodity) {
		this.stockCommodity = stockCommodity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
