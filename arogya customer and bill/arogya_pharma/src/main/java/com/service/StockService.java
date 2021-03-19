package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Stock;

import com.dao.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	//add the record
	public String addStock(Stock sk)
	{
		Optional<Stock> st = stockRepository.findById(sk.getStock_id());
		
		if(st.isPresent())
		{
			return "record already exist";
		}
		else 
		{
			stockRepository.save(sk);
			return "record stored";
		}
	}
	
	
	//see all the record
	public List<Stock> showAllRecord()
	{
		return stockRepository.findAll();
	}
	
	// delete the record
	
	public String deleteRecord(int id)
	{
		Optional<Stock> st = stockRepository.findById(id);
		
		if(st.isPresent())
		{
			stockRepository.deleteById(id);
			return "Record deleted";
		}
		else
		{
			return "Record not found";
		}
	}
	
	//updating    ****** useless*****
	public String updateRecord(Stock sk)
	{
		Optional<Stock> op = stockRepository.findById(sk.getStock_id());
		if(op.isPresent())
		{
			stockRepository.saveAndFlush(sk);
			return "Updated ";
		}
		else
		{
			return "Record not found";
		}
	}
	
	
	
}
