package com.wellsfargo.batch5.pms.model;

import java.util.Set;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class InvestorModel extends UserModel{
	
	@NotNull(message="is New user cannot be null")
	private Boolean isNewUser;

	@NotNull(message="PAN cannot be null")
	@NotBlank(message="PAN cannot be blank")
	@Size(min=10, max=10, message="PAN should be 10 alphanumeric")
	private String panId;

	@NotNull(message="Portfolio value cannot be null")
	@NotBlank(message="Portfolio value cannot be blank")
	private Double currentPortfolioValue;

	@NotNull(message="Invested amount cannot be null")
	@NotBlank(message="Invested Amount cannot be blank")
	@DecimalMin(value="0", message="Invested amount cannot be less than 0")
	private Double amountInvested;
	
	@NotNull(message="Earned amount cannot be null")
	@NotBlank(message="Earned Amount cannot be blank")
	private Double amountEarned;
	
	@NotNull(message="Portfolio wallet cannot be null")
	@NotBlank(message="Portfolio wallet cannot be blank")
	private PortfolioWalletModel portWallet;

	private Set<InvestorCommodityDetailsModel> invCommodity;

	private Set<InvestorStockDetailsModel> invStock;
	
	public PortfolioWalletModel getPortWallet() {
		return portWallet;
	}

	public void setPortWallet(PortfolioWalletModel portWallet) {
		this.portWallet = portWallet;
	}

	

	public InvestorModel()
	{
		
	}
	
	public InvestorModel(Boolean isNewUser, String panId, Double currentPortfolioValue, Double amountInvested,Double amountEarned, Integer userId, String password, String role, String emailId, String phNumber, String userName, String name) {
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

