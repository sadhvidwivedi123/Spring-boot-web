package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wellsfargo.batch5.pms.entity.InvestorCommodityDetailsEntity;

@Repository
public interface InvestorCommodityDetailsRepo extends JpaRepository<InvestorCommodityDetailsEntity, Integer>{

}
