package com.wellsfargo.batch5.pms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="commission")
public class CommisionEntity {
	@GeneratedValue
	@Id
	@Column(name="com_id")
	private Integer commisionId;
	@Column(name="commision_rate")
	private final Double commissonRate = 0.02;
	@Column(name="commision_value")
	private Double commisionValue;
	
	@Column(name="date")
	private LocalDate date;
	public CommisionEntity()
	{
		
	}
	
	public Integer getCommisionId() {
		return commisionId;
	}

	public void setCommisionId(Integer commisionId) {
		this.commisionId = commisionId;
	}

	public CommisionEntity(Double commisionValue, LocalDate date) {
		super();
		this.commisionValue = commisionValue;
		this.date = date;
	}

	public Double getCommisionValue() {
		return commisionValue;
	}
	public void setCommisionValue(Double commisionValue) {
		this.commisionValue = commisionValue;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getCommissonRate() {
		return commissonRate;
	}
	
}
