package com.wellsfargo.batch5.pms.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;
import com.wellsfargo.batch5.pms.entity.TransactionEntity;
@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, Integer>{
	
	public List<TransactionEntity> findAllByDateBetween(LocalDate fromDate,LocalDate toDate);

	public Optional<TransactionEntity> findAllByDateBetweenAndUserId(LocalDate fromDate, LocalDate toDate,
			Integer userId);

}
