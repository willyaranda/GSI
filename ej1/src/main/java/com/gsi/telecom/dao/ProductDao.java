package com.gsi.telecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.gsi.telecom.data.Product;

/**
 * Interface that shows all the methods that should have all the different DB
 * access
 * 
 * @author willyaranda
 * 
 */
public interface ProductDao extends BasicDao<Product> {
	/**
	 * Returns all valid products in the database in a list
	 * 
	 * @return <code>List&lt;Product&gt;</code>
	 * @throws SQLException
	 */
	public List<Product> getValidProducts() throws SQLException;
}
