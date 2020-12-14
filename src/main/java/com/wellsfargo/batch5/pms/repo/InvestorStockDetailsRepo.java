package com.wellsfargo.batch5.pms.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wellsfargo.batch5.pms.entity.InvestorStockDetailsEntity;
import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;

@Repository
public interface InvestorStockDetailsRepo extends JpaRepository<InvestorStockDetailsEntity, Integer>{

	List<InvestorStockDetailsEntity> findAllByInvestor(Integer userId);

}
