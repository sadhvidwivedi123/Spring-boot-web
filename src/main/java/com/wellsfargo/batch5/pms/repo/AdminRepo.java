package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Integer>{
	
	boolean existsByUserName(String username);

}
