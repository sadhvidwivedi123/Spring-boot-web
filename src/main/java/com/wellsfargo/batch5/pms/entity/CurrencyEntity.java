package com.wellsfargo.batch5.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class CurrencyEntity {

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="value_In_INR")
    private double valueInINR;

    public CurrencyEntity() {
    	
    }

	public CurrencyEntity(String name, double valueInINR) {
		this.name = name;
		this.valueInINR = valueInINR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValueInINR() {
		return valueInINR;
	}

	public void setValueInINR(double valueInINR) {
		this.valueInINR = valueInINR;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", valueInINR=" + valueInINR + "]";
	}
    
    
}
