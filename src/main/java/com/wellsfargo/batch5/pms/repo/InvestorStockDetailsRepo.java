package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wellsfargo.batch5.pms.entity.InvestorStockDetailsEntity;

@Repository
public interface InvestorStockDetailsRepo extends JpaRepository<InvestorStockDetailsEntity, Integer>{

}
