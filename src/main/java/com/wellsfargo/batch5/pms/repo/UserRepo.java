package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wellsfargo.batch5.pms.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	boolean existsByUserName(String userName);
	
	UserEntity findByUserName(String userName);

}
