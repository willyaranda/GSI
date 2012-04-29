package com.gsi.telecom.dao;

import com.gsi.telecom.data.Customer;

/**
 * Interface that has all functions that must be implemented by all of the
 * classes that implements this.
 * 
 * @author willyaranda
 * 
 */
public interface CustomerDao extends BasicDao<Customer> {
	// This function should be uncommented on the case that HashMap could
	// properly implement it
	// public List<Customer> getProductsForCustomer(Customer customer);
}
