/*package com.gsi.telecom;

import com.gsi.telecom.data.Product;
import com.gsi.telecom.database.ProductDaoHash;

import junit.framework.TestCase;

public class TestDaoHash extends TestCase {

	public void testProductDaoHashInsert() {
		Product product = new Product();
		product.setId(1);

		ProductDaoHash tablaHash = new ProductDaoHash();
		tablaHash.add(product);
		assertEquals(product, tablaHash.find(1));
	}
}
 */

package com.gsi.telecom;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import com.gsi.telecom.data.Customer;
import com.gsi.telecom.data.Product;
import com.gsi.telecom.database.CustomerDaoHash;
import com.gsi.telecom.database.ProductDaoHash;

/**
 * @author Noelia Morón Tabernero mtnoelia@gmail.com This class tests DAO
 *         objects for Customer and Product implemented with HashTable
 */
public class TestDaoHash extends TestCase {

	// Random value to generate random fields
	private Random random = new Random();

	/*
	 * Creates a Customer object with dummy and random attributes
	 * 
	 * @return valid Customer object built with dummy values
	 */
	private Customer buildValidCustomer() {
		// Build sample customer
		Customer customer = new Customer();

		// Fill attributes with dummy and random strings
		customer.setId(new Integer(new Integer(random.nextInt())));
		String randomString = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setName(randomString);
		randomString = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setLastname(randomString);
		randomString = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setAddress(randomString);
		return customer;
	}

	/*
	 * Creates a Product object with dummy and random attributes
	 * 
	 * @return valid Product object built with dummy values
	 */
	private Product buildValidProduct() {
		// Build sample product
		Product product = new Product();

		// Fill attributes with dummy and random strings
		product.setId(new Integer(new Integer(random.nextInt())));
		String randomString = Long.toString(Math.abs(random.nextLong()), 10);
		product.setDescription(randomString);
		randomString = Long.toString(Math.abs(random.nextLong()), 10);
		product.setName(randomString);
		product.setValid(random.nextBoolean());
		return product;
	}

	/*
	 * Tests CustomerDaoHash.add function In order to test ONLY CustomerDaoHash
	 * "add" functionality, the rest of needed functions are executed directly
	 * from the HashTable
	 */
	public void testCustomerDaoHashAdd() {
		// Build reference customer
		Customer customer = buildValidCustomer();

		// Build Customer dao object
		CustomerDaoHash customerDao = new CustomerDaoHash();

		// Add product to DB
		customerDao.add(customer);

		// Check customer added in CustomerDao HastTable
		HashMap<Integer, Customer> hashMapCustomer = customerDao
				.getCustomersTable();
		Customer customerDB = hashMapCustomer.get(customer.getId());
		assertNotNull(customerDB);
		assertEquals(customerDB.getAddress(), customerDB.getAddress());
		assertEquals(customerDB.getName(), customerDB.getName());
		assertEquals(customerDB.getLastname(), customerDB.getLastname());
	}

	/*
	 * Tests CustomerDaoHash.delete function In order to test ONLY
	 * CustomerDaoHash "delete" functionality, the rest of needed functions are
	 * executed directly from the HashTable
	 */
	public void testCustomerDaoHashDelete() {
		// Build reference product
		Customer customer = buildValidCustomer();

		// Customer dao
		CustomerDaoHash customerDao = new CustomerDaoHash();

		// Create a HastTable with a customer and set it as customerDao storage
		HashMap<Integer, Customer> hashMapCustomer = new HashMap<Integer, Customer>();
		hashMapCustomer.put(customer.getId(), customer);
		customerDao.setCustomersTable(hashMapCustomer);

		// Delete customer
		customerDao.delete(customer);

		// Check product deleted from hash HastTable
		hashMapCustomer = customerDao.getCustomersTable();
		Customer customerDB = hashMapCustomer.get(customer.getId());
		assertNull(customerDB);
	}

	/*
	 * Tests CustomerDaoHash.find function In order to test ONLY CustomerDaoHash
	 * "find" functionality, the rest of needed functions are executed directly
	 * from the HashTable
	 */
	public void testCustomerDaoHashFind() {
		// Build reference customer
		Customer customer = buildValidCustomer();

		// Customer dao
		CustomerDaoHash customerDao = new CustomerDaoHash();

		// Create a hashmap with a customer and set it as customerDao storage
		HashMap<Integer, Customer> hashMapCustomer = new HashMap<Integer, Customer>();
		hashMapCustomer.put(customer.getId(), customer);
		customerDao.setCustomersTable(hashMapCustomer);

		// Check find result
		hashMapCustomer = customerDao.getCustomersTable();
		Customer customerDB = hashMapCustomer.get(customer.getId());
		Customer customerDBFind = customerDao.find(customer.getId());
		assertNotNull(customerDBFind);
		assertEquals(customerDBFind, customerDB);
	}

	/*
	 * Tests CustomerDaoHash.update function In order to test ONLY
	 * CustomerDaoHash "update" functionality, the rest of needed functions are
	 * executed directly from the HashTable
	 */
	public void testCustomerDaoHashUpdate() {
		// Build reference customer
		Customer customer = buildValidCustomer();

		// Customer dao
		CustomerDaoHash customerDao = new CustomerDaoHash();

		// Create a hashmap with a customer and set it as customerDao storage
		HashMap<Integer, Customer> hashMapCustomer = new HashMap<Integer, Customer>();
		hashMapCustomer.put(customer.getId(), customer);
		customerDao.setCustomersTable(hashMapCustomer);

		// Update product
		String randomName = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setName(randomName);
		customerDao.update(customer);

		// Check product updated in hash table
		hashMapCustomer = customerDao.getCustomersTable();
		Customer customerDB = hashMapCustomer.get(customer.getId());
		assertNotNull(customerDB);
		assertEquals(customer.getName(), customerDB.getName());
	}

	/*
	 * Tests ProductDaoHash.add function In order to test ONLY ProductDaoHast
	 * "add" functionality, the rest of needed functions are executed directly
	 * from the HashTable
	 */
	public void testProductDaoHashAdd() {
		// Build reference product
		Product product = buildValidProduct();

		// Build Product dao object
		ProductDaoHash productDao = new ProductDaoHash();

		// Add product to DB
		productDao.add(product);

		// Check product added in ProductDao HastTable
		HashMap<Integer, Product> hashMapProducts = productDao
				.getProductsTable();
		Product productDB = hashMapProducts.get(product.getId());
		assertNotNull(productDB);
		assertEquals(product.getDescription(), productDB.getDescription());
		assertEquals(product.getName(), productDB.getName());
		assertEquals(product.getValid(), productDB.getValid());
	}

	/*
	 * Tests ProductDaoHash.delete function In order to test ONLY ProductDaoHash
	 * "delete" functionality, the rest of needed functions are executed
	 * directly from the HashTable
	 */
	public void testProductDaoHashDelete() {
		// Build reference product
		Product product = buildValidProduct();

		// Product dao
		ProductDaoHash productDao = new ProductDaoHash();

		// Create a HastTable with a product and set it as productDao storage
		HashMap<Integer, Product> hashMapProducts = new HashMap<Integer, Product>();
		hashMapProducts.put(product.getId(), product);
		productDao.setProductsTable(hashMapProducts);

		// Delete product
		productDao.delete(product);

		// Check product deleted from hash HastTable
		hashMapProducts = productDao.getProductsTable();
		Product productDB = hashMapProducts.get(product.getId());
		assertNull(productDB);
	}

	/*
	 * Tests ProductDaoHash.find function In order to test ONLY ProductDaoHash
	 * "find" functionality, the rest of needed functions are executed directly
	 * from the HashTable
	 */
	public void testProductDaoHashFind() {
		// Build reference product
		Product product = buildValidProduct();

		// Product dao
		ProductDaoHash productDao = new ProductDaoHash();

		// Create a hashmap with a product and set it as productDao storage
		HashMap<Integer, Product> hashMapProducts = new HashMap<Integer, Product>();
		hashMapProducts.put(product.getId(), product);
		productDao.setProductsTable(hashMapProducts);

		// Check find result
		hashMapProducts = productDao.getProductsTable();
		Product productDB = hashMapProducts.get(product.getId());
		Product productDBFind = productDao.find(product.getId());
		assertNotNull(productDBFind);
		assertEquals(productDBFind, productDB);
	}

	/*
	 * Tests ProductDaoHash.getValidProducts function In order to test ONLY
	 * ProductDaoHash "getValidProducts" functionality, the rest of needed
	 * functions are executed directly from the HashTable
	 */
	public void testProductDaoHashGetValidProducts() {
		// Build reference products
		Product productValid1 = buildValidProduct();
		productValid1.setValid(true);
		Product productValid2 = buildValidProduct();
		productValid2.setValid(true);
		Product productNoValid1 = buildValidProduct();
		productNoValid1.setValid(false);

		// Product dao
		ProductDaoHash productDao = new ProductDaoHash();

		// Create a hashmap with a product and set it as productDao storage
		HashMap<Integer, Product> hashMapProducts = new HashMap<Integer, Product>();
		hashMapProducts.put(productValid1.getId(), productValid1);
		hashMapProducts.put(productValid2.getId(), productValid2);
		hashMapProducts.put(productNoValid1.getId(), productNoValid1);
		productDao.setProductsTable(hashMapProducts);

		// Check find result
		List<Product> product_list = productDao.getValidProducts();
		assertEquals(2, product_list.size());
		Product reference = product_list.get(0);
		if (!reference.equals(productValid1)
				&& !reference.equals(productValid2))
			assertFalse(true);
		reference = product_list.get(1);
		if (!reference.equals(productValid1)
				&& !reference.equals(productValid2))
			assertFalse(true);
	}

	/*
	 * Tests ProductDaoHash.update function In order to test ONLY ProductDaoHash
	 * "update" functionality, the rest of needed functions are executed
	 * directly from the HashTable
	 */
	public void testProductDaoHashUpdate() {
		// Build reference product
		Product product = buildValidProduct();

		// Product dao
		ProductDaoHash productDao = new ProductDaoHash();

		// Create a hashmap with a product and set it as productDao storage
		HashMap<Integer, Product> hashMapProducts = new HashMap<Integer, Product>();
		hashMapProducts.put(product.getId(), product);
		productDao.setProductsTable(hashMapProducts);

		// Update product
		String randomDescription = Long.toString(Math.abs(random.nextLong()),
				10);
		product.setDescription(randomDescription);
		productDao.update(product);

		// Check product updated in hash table
		hashMapProducts = productDao.getProductsTable();
		Product productDB = hashMapProducts.get(product.getId());
		assertNotNull(productDB);
		assertEquals(product.getDescription(), productDB.getDescription());
	}
}