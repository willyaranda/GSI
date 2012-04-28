package com.gsi.telecom.database;

import java.util.HashMap;

import com.gsi.telecom.dao.CustomerDao;
import com.gsi.telecom.data.Customer;

public class CustomerDaoHash implements CustomerDao {
	
	private HashMap<Integer, Customer> customerTable;
	
	public CustomerDaoHash() {
		customerTable = new HashMap<Integer, Customer>();
	}

	public HashMap<Integer, Customer> getCustomersTable() {
		return customerTable;
	}

	@Override
	public void add(Customer customer) {
		customerTable.put(customer.getId(), customer);
	}

	public void setCustomersTable(HashMap<Integer, Customer> hashMapCustomer) {
		this.customerTable = hashMapCustomer;
	}
	
	@Override
	public void delete(Customer customer) {
		customerTable.remove(customer.getId());
	}
	
	@Override
	public Customer update(Customer customer) {	
		return customerTable.put(customer.getId(), customer);
	}

	//Wrapper
	public Customer find(Integer id) {
		return select(id);
	}

	@Override
	public Customer select(Integer id) {
		return customerTable.get(id);
	}
}
