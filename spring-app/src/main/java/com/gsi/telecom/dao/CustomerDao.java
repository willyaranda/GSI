package com.gsi.telecom.dao;

import java.util.List;

import com.gsi.telecom.data.Customer;
import com.gsi.telecom.data.Product;

public interface CustomerDao extends BasicDao<Customer>{

	public List<Product> getProductsForCustomer(Customer customer);
}
