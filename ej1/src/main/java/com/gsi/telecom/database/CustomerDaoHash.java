package com.gsi.telecom.database;

import java.util.HashMap;

import com.gsi.telecom.dao.CustomerDao;
import com.gsi.telecom.data.Customer;

/**
 * Implements CustomerDao interface for HashMaps
 * 
 * @author willyaranda
 * 
 */
public class CustomerDaoHash implements CustomerDao {

	// Stores the info of Customers in a HashMap (k-v)
	private HashMap<Integer, Customer> customerTable;

	/**
	 * Constructor
	 */
	public CustomerDaoHash() {
		customerTable = new HashMap<Integer, Customer>();
	}

	@Override
	public void add(Customer customer) {
		customerTable.put(customer.getId(), customer);
	}

	@Override
	public void delete(Customer customer) {
		customerTable.remove(customer.getId());
	}

	// Wrapper
	public Customer find(Integer id) {
		return select(id);
	}

	/**
	 * Returns the HashMap
	 * 
	 * @return the HashMap
	 */
	public HashMap<Integer, Customer> getCustomersTable() {
		return customerTable;
	}

	@Override
	public Customer select(Integer id) {
		return customerTable.get(id);
	}

	/**
	 * Sets the HashMap
	 * 
	 * @param hashMapCustomer
	 */
	public void setCustomersTable(HashMap<Integer, Customer> hashMapCustomer) {
		this.customerTable = hashMapCustomer;
	}

	@Override
	public Customer update(Customer customer) {
		return customerTable.put(customer.getId(), customer);
	}
}
