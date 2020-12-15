package com.wellsfargo.batch5.pms.repo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;

@Repository
public interface StockRepo extends JpaRepository<StockEntity, Integer>{
	
	StockEntity findByCompany(CompanyEntity company);
	
	StockEntity findByStockId(Integer stockId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	 @Query("UPDATE StockEntity stock SET stock.stockExchange=:stockExchange,stock.currentPrice=:currentPrice,stock.date=:date,stock.time=:time WHERE stock.stockId=:stockId")
	void update(@Param("stockId") Integer stockId,@Param("stockExchange") String stockExchange,@Param("currentPrice") Double currentPrice,@Param("date") LocalDate date,@Param("time") LocalTime time);

}
