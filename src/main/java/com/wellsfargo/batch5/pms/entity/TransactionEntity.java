package com.wellsfargo.batch5.pms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_history")
public class TransactionEntity {
	
	@Id
	@GeneratedValue
	@Column(name="transaction_id")
	private Integer transactionId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="transaction_type")//buy or sell
	private String transactionType;
	
	@Column(name="stock_commodity")
	private String stockCommodity;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="commodity_name")
	private String commodityName;
	
	@Column(name="quantity")
	private Integer quantity;
	
	public TransactionEntity()
	{
		
	}

	public TransactionEntity(Integer transactionId, Integer userId, String transactionType, String stockCommodity,
			Double amount, LocalDate date,String companyName, String commodityName,Integer quantity) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionType = transactionType;
		this.stockCommodity = stockCommodity;
		this.amount = amount;
		this.date=date;
		this.companyName=companyName;
		this.commodityName=commodityName;
		this.quantity=quantity;
	}

	@Override
	public String toString() {
		return "TransactionEntity [transactionId=" + transactionId + ", userId=" + userId + ", transactionType="
				+ transactionType + ", stockCommodity=" + stockCommodity + ", amount=" + amount + "]";
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
	

}
