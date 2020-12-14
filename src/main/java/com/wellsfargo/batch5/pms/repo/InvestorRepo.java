package com.wellsfargo.batch5.pms.repo;

import java.time.LocalDate;
import java.time.LocalTime;

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

}
