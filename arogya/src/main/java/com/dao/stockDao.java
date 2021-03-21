package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Stock;


@Repository
public class stockDao {

	@Autowired
	EntityManagerFactory factory;
	
	
	

	 
	  public List<Stock> getAllStockByname()
	{
		EntityManager emf = factory.createEntityManager();
		//Query qry = emf.createNativeQuery("select * from stock order by item_name");
		//Query qry =emf.createQuery("select s from stock s order by item_name");
		Query qry = emf.createQuery("select s from Stock s order by item_name");
		List<Stock> list = qry.getResultList();
		return list;
	}

	

	  
	  public List<Stock> getAllStockBynameDesc()
	{
		EntityManager emf = factory.createEntityManager();
		//Query qry = emf.createNativeQuery("select * from stock order by item_name desc");
		Query qry =emf.createQuery("select s from Stock s order by s.item_name desc");
		//Query qry =emf.createQuery("select s from Stock s ");
		List<Stock> list = qry.getResultList();
		return list;
	}

	public int upd(float pric, int id)
	{
		EntityManager emf = factory.createEntityManager();
		//Query qry = emf.createNativeQuery("update stock set price=pric where stock_id=id");
		
		
		String INSERT_SQL1 = "update stock set price=?1 where stock_id=?2";
		emf.createQuery(INSERT_SQL1).setParameter(1, pric).setParameter(2, id)
		
		.executeUpdate();
		
		
		return 1;
	}
	
	
	
}
