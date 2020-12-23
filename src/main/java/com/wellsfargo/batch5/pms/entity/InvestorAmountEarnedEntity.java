package com.wellsfargo.batch5.pms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="investor_amountEarned")
public class InvestorAmountEarnedEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer userId;
	
	private Double amountEarned;
	
	private LocalDate date;
	
	

	public InvestorAmountEarnedEntity(Integer userId, Double amountEarned, LocalDate date) {
		super();
		this.userId = userId;
		this.amountEarned = amountEarned;
		this.date = date;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getAmountEarned() {
		return amountEarned;
	}

	public void setAmountEarned(Double amountEarned) {
		this.amountEarned = amountEarned;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
