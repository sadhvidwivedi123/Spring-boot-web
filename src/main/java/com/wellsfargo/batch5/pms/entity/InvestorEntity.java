package com.wellsfargo.batch5.pms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("investor")
@Table(name="investor")
public class InvestorEntity extends UserEntity{
	
	@Column(name="is_new_user", nullable=false)
	private Boolean isNewUser;
	
	@Column(name="pan",  nullable=false, unique=true)
	private String panId;
	
	@Column(name="current_portfolio_value")
	private Double currentPortfolioValue;
	
	@Column(name="invested_amount")
	private Double amountInvested;
	
	@Column(name="amount_earned")
	private Double amountEarned;
	
	@Embedded
	private PortfolioWalletEntity portWallet;
	
	@OneToMany(mappedBy="investor")
	private Set<InvestorCommodityDetailsEntity> invCommodity;
	
	@OneToMany(mappedBy="investor")
	private Set<InvestorStockDetailsEntity> invStock;
	
	public PortfolioWalletEntity getPortWallet() {
		return portWallet;
	}

	public void setPortWallet(PortfolioWalletEntity portWallet) {
		this.portWallet = portWallet;
	}

	

	public InvestorEntity()
	{
		
	}
	
	public InvestorEntity(Boolean isNewUser, String panId, Double currentPortfolioValue, Double amountInvested,Double amountEarned, Integer userId, String password, String role, String emailId, String phNumber, String userName, String name) {
		super(userId, userName,password,role,emailId,phNumber,name);
		this.isNewUser = isNewUser;
		this.panId = panId;
		this.currentPortfolioValue = currentPortfolioValue;
		this.amountInvested = amountInvested;
		this.amountEarned = amountEarned;
	}
	
	public Boolean getIsNewUser() {
		return isNewUser;
	}
	public void setIsNewUser(Boolean isNewUser) {
		this.isNewUser = isNewUser;
	}
	public String getPanId() {
		return panId;
	}
	public void setPanId(String panId) {
		this.panId = panId;
	}
	public Double getCurrentPortfolioValue() {
		return currentPortfolioValue;
	}
	public void setCurrentPortfolioValue(Double currentPortfolioValue) {
		this.currentPortfolioValue = currentPortfolioValue;
	}
	public Double getAmountInvested() {
		return amountInvested;
	}
	public void setAmountInvested(Double amountInvested) {
		this.amountInvested = amountInvested;
	}
	public Double getAmountEarned() {
		return amountEarned;
	}
	public void setAmountEarned(Double amountEarned) {
		this.amountEarned = amountEarned;
	}

	

}

