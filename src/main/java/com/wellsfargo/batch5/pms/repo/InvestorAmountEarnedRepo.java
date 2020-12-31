package com.wellsfargo.batch5.pms.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.InvestorAmountEarnedEntity;

@Repository
public interface InvestorAmountEarnedRepo extends JpaRepository<InvestorAmountEarnedEntity, Integer>{
	
	
	public List<InvestorAmountEarnedEntity> findAllByUserId(Integer id);
	
	public List<InvestorAmountEarnedEntity> findByDateBetween(LocalDate from,LocalDate to);
	

}
