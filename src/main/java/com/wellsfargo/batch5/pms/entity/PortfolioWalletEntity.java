package com.wellsfargo.batch5.pms.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PortfolioWalletEntity {
	
	@Column(name="walletBalance")
	private Double walletBalance;
	
	public PortfolioWalletEntity()
	{
		
	}

	public PortfolioWalletEntity(Double walletBalance) {
		super();
		this.walletBalance = walletBalance;
	}

	public Double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}

	
}
