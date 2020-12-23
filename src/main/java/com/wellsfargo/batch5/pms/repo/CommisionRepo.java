package com.wellsfargo.batch5.pms.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.CommisionEntity;

@Repository
public interface CommisionRepo extends JpaRepository<CommisionEntity, Integer>{
	
	public List<CommisionEntity> findAllByDateBetween(LocalDate fromDate,LocalDate toDate);

}
