package com.gsi.telecom.dao;

import java.util.List;

import com.gsi.telecom.data.Product;

public interface ProductDao extends BasicDao<Product>{

	public List getValidProducts();
}
