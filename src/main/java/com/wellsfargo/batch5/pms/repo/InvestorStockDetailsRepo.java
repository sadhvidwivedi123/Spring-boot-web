package com.wellsfargo.batch5.pms.repo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.InvestorCommodityDetailsEntity;
import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.InvestorStockDetailsEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.InvestorCommodityDetailsModel;

@Repository
public interface InvestorStockDetailsRepo extends JpaRepository<InvestorStockDetailsEntity, Integer>{

	List<InvestorStockDetailsEntity> findAllByInvestor(InvestorEntity investor);
	boolean existsByStock(StockEntity stock)throws PortfolioException;
	
	InvestorStockDetailsEntity findByStock(StockEntity stock);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	 @Query("UPDATE InvestorStockDetailsEntity isde SET isde.unit=:quantity, isde.date=:date WHERE isde.investorStockId=:key")
	void update(@Param("quantity") Integer quantity,@Param("key") Integer key, @Param("date") LocalDate date);

	
	

}
