package com.wellsfargo.batch5.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer>{
	
	 public List<CompanyEntity> findByCompanyTitleContaining(String name);
	 
	 public List<CompanyEntity> findAllBySector(String sector);
}
