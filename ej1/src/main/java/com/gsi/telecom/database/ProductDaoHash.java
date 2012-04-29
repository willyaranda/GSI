package com.gsi.telecom.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.gsi.telecom.dao.ProductDao;
import com.gsi.telecom.data.Product;

/**
 * Implements the ProductDao interface for HashMaps
 * 
 * @author willyaranda
 * 
 */
public class ProductDaoHash implements ProductDao {

	/**
	 * Store the products in a HashMap key-value
	 */
	private HashMap<Integer, Product> productTable;

	/**
	 * Constructor, creates the new hashMap of Integer, Product
	 */
	public ProductDaoHash() {
		productTable = new HashMap<Integer, Product>();
	}

	@Override
	public void add(Product basic) {
		System.out.println("Adding ->" + basic.toString());
		productTable.put(basic.getId(), basic);
	}

	@Override
	public void delete(Product basic) {
		productTable.remove(basic.getId());
	}

	// Wrapper for select
	public Product find(Integer id) {
		return select(id);
	}

	/**
	 * Returns the productTable HashMap
	 * 
	 * @return the productTable
	 */
	public HashMap<Integer, Product> getProductsTable() {
		return productTable;
	}

	@Override
	public List<Product> getValidProducts() {
		List<Product> list = new ArrayList<Product>();
		Iterator<Product> itr = productTable.values().iterator();
		while (itr.hasNext()) {
			Product p = itr.next();
			if (p.getValid()) {
				list.add(p);
			}
		}
		return list;
	}

	@Override
	public Product select(Integer id) {
		System.out.println("Searching for Id -> " + id
				+ this.productTable.containsKey(id));
		return this.productTable.get(id);
	}

	/**
	 * Sets the productTable HashMap
	 * 
	 * @param hashMapProducts
	 */
	public void setProductsTable(HashMap<Integer, Product> hashMapProducts) {
		this.productTable = hashMapProducts;
	}

	@Override
	public Product update(Product basic) {
		return productTable.put(basic.getId(), basic);
	}
}