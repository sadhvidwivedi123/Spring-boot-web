package com.wellsfargo.batch5.pms.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch5.pms.entity.InvestorEntity;

@Repository
public interface InvestorRepo extends JpaRepository<InvestorEntity, Integer>{
	
	boolean existsByPanId(String pan);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE InvestorEntity i SET i.amountEarned=:earned, i.amountInvested=:invested, i.currentPortfolioValue=:currPortfoliovalue WHERE i.panId=:panid")
	void updateInvestorHome(@Param("earned") Double earned, @Param("invested") Double invested, @Param("currPortfoliovalue") Double currPortfoliovalue, @Param("panid") String panid);
	
	
}
