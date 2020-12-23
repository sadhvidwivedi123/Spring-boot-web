package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.InvestorAmountEarnedEntity;

@Repository
public interface InvestorAmountEarnedRepo extends JpaRepository<InvestorAmountEarnedEntity, Integer>{
	

}
