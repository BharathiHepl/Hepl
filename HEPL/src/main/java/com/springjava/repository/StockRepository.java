package com.springjava.repository;

import java.util.List;

import com.springjava.model.Stock;

public interface StockRepository {

	List<Stock> findAll();

}
