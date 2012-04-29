package com.gsi.telecom;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

import com.gsi.telecom.data.Customer;
import com.gsi.telecom.database.ConnectionDaoMySql;
import com.gsi.telecom.database.CustomerDaoMySql;

public class TestDaoMySqlPropio extends TestCase {

	// Local Unit test connection to MySql telecom database
	private ConnectionDaoMySql connectionDaoMysql = new ConnectionDaoMySql();
	private CustomerDaoMySql customerDaoMysql = new CustomerDaoMySql();

	public void testConnectionMySql() throws SQLException {
		Connection conn = null;
		try {
			conn = connectionDaoMysql.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			conn.close();
			assertNotNull("Connection is null", conn);
		}
	}

	public void testCustomerAddMySql() throws SQLException {
		// Create a new custom customer
		Customer cust1 = new Customer(-1, "name-1", "lastname-1", "address-1");
		// Delete previous cust1, just in case
		customerDaoMysql.delete(cust1);
		// Add the just created customer
		customerDaoMysql.add(cust1);

		// Find the added customer in the DB
		Customer cust2 = new Customer();
		cust2 = customerDaoMysql.find(-1);

		// Assert if something is different
		assertEquals(cust1.getId(), cust2.getId());
		assertEquals(cust1.getName(), cust2.getName());
		assertEquals(cust1.getLastname(), cust2.getLastname());
		assertEquals(cust1.getAddress(), cust2.getAddress());
		// And delete object to clean up after ourselves
		customerDaoMysql.delete(cust1);
	}

	public void testCustomerDeleteMySql() throws SQLException {
		// Create a new custom customer
		Customer cust1 = new Customer(-1, "name-1", "lastname-1", "address-1");
		// Delete previous cust1, just in case
		customerDaoMysql.delete(cust1);
		// Add the just created customer
		customerDaoMysql.add(cust1);

		// Delete added customer
		customerDaoMysql.delete(cust1);
		// Find the added customer in the DB
		Customer cust2 = new Customer();
		cust2 = customerDaoMysql.find(-1);

		// Assert if cust2 is not null (so it's not deleted from the DB
		assertNull("The object is not null, NOT DELETED", cust2);
		// And delete object to clean up after ourselves
		customerDaoMysql.delete(cust1);
	}

	public void testCustomerFindMySql() throws SQLException {
		// this is the same test as testCustomerAddMySql()
		// Create a new custom customer
		Customer cust1 = new Customer(-1, "name-1", "lastname-1", "address-1");
		// Delete previous cust1, just in case
		customerDaoMysql.delete(cust1);
		// Add the just created customer
		customerDaoMysql.add(cust1);

		// Find the added customer in the DB
		Customer cust2 = new Customer();
		cust2 = customerDaoMysql.find(-1);

		// Assert if something is different
		assertEquals(cust1.getId(), cust2.getId());
		assertEquals(cust1.getName(), cust2.getName());
		assertEquals(cust1.getLastname(), cust2.getLastname());
		assertEquals(cust1.getAddress(), cust2.getAddress());
		// And delete object to clean up after ourselves
		customerDaoMysql.delete(cust1);
	}

	public void testCustomerSelectMySql() throws SQLException {
		// This is the Find function
		testCustomerFindMySql();
	}

	public void testCustomerUpdateMySql() throws SQLException {
		// Create a new custom customer
		Customer cust1 = new Customer(-1, "name-1", "lastname-1", "address-1");
		// Delete previous cust1, just in case
		customerDaoMysql.delete(cust1);
		// Add the just created customer
		customerDaoMysql.add(cust1);

		// Now duplicate and change some attrs
		Customer cust1Updt = new Customer(cust1);
		cust1Updt.setName("name-1-updated");
		cust1Updt.setLastname("lastname-1-updated");
		cust1Updt.setAddress("address-1-updated");

		// Now, update the db
		customerDaoMysql.update(cust1Updt);

		// Find the updated customer in the DB
		Customer cust2 = new Customer();
		cust2 = customerDaoMysql.find(-1);

		// Assert if something is different
		assertEquals(cust1Updt.getId(), cust2.getId());
		assertEquals(cust1Updt.getName(), cust2.getName());
		assertEquals(cust1Updt.getLastname(), cust2.getLastname());
		assertEquals(cust1Updt.getAddress(), cust2.getAddress());
		// And delete object to clean up after ourselves
		customerDaoMysql.delete(cust1);
	}
}
