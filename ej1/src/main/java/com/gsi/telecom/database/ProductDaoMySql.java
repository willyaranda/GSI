package com.gsi.telecom.database;

import java.sql.Connection;
import java.util.List;

import com.gsi.telecom.dao.ProductDao;
import com.gsi.telecom.data.Product;


public class ProductDaoMySql extends ConnectionDaoMySql implements ProductDao {

	@Override
	public List<Product> getValidProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Product basic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Product basic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product basic) {
		return basic;
	}

	//Wrapper
	public Product find(Integer id) {
		return select(id);
	}

}
