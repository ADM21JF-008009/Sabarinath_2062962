package com.cognizant.ormlearn.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.respository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Transactional
	public List<Stock> getStocks() {
		return stockRepository.findAll();
	}
	
	@Transactional
	public List<Stock> getStockByCodeAndDate(){
		return stockRepository.findByCodeAndDateBetween("FB", Date.valueOf("2019-09-01"), Date.valueOf("2019-09-30"));
	}
	@Transactional
	public List<Stock> getStockGreaterThan(){
		return stockRepository.findByCodeAndCloseGreaterThan("GOOGL",new BigDecimal(1250.00));
	}
	@Transactional
	public List<Stock> getTop3ByVolume(){
		return stockRepository.findTop3ByOrderByVolumeAsc();
	}
	
	@Transactional
	public List<Stock> getTop3ByCode(){
		return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
	}
}
