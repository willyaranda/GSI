package com.gsi.telecom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import com.gsi.telecom.data.Customer;
import com.gsi.telecom.data.Product;
import com.gsi.telecom.database.ConnectionDaoDerby;
import com.gsi.telecom.database.CustomerDaoDerby;
import com.gsi.telecom.database.ProductDaoDerby;

import junit.framework.TestCase;

/**
 * @author Noelia Morón Tabernero mtnoelia@gmail.com
 * This class tests DAO objects for Customer and Product
 * 	implemented with Derby
 */
public class TestDaoDerby extends TestCase {
	
	// Local Unit test connection to Derby telecom database
	private ConnectionDaoDerby connectionDaoDerby = new ConnectionDaoDerby();
	
	// Random value to generate random fields
	private Random random = new Random();
	
	/* Generates the String order for insert Derby order in Customer table
	 * 	with given Customer fields in "values" clause
	 * @customer reference customer for "values" clause 
	 * @return String order
	 * */
	private String getOrderAddCustomer(Customer customer) {
		return "insert into Customer (id, name, lastname, address) VALUES ('" +
		(customer.getId() != null? customer.getId(): " \" \"") + "', '"+
		(customer.getName() != null? customer.getName(): " \" \"") + "', '"+
		(customer.getLastname() != null? customer.getLastname() : " \"\" ") + "', '"+
		(customer.getAddress() != null? customer.getAddress(): " \"\" ") + "');";
	}
	
	/* Generates the String order for insert Derby order in Product table
	 * 	with given Product fields in "values" clause
	 * @product reference product for "values" clause 
	 * @return String order
	 * */
	private String getOrderAddProduct(Product product) {
		return "insert into Product (id, name, price, description, valid) VALUES ('" +
		(product.getId() != null? product.getId(): " \" \"") + "', '"+
		(product.getName() != null? product.getName(): " \" \"") + "', '"+
		(product.getPrice() != null? product.getPrice(): " \" \"") + "', '"+
		(product.getDescription() != null? product.getDescription() : " \"\" ") + "', "+
		(product.getValid()? "'1'": "'0'")+");";
	}
	
	/* Generates the String order for insert Derby order in Customer_Product table
	 * 	with given Customer and Product fields in "values" clause
	 * @customer reference customer for "values" clause 
	 * @product reference product for "values" clause 
	 * @return String order
	 * */
	private String getOrderAddCustomerProduct(Customer customer, Product product) {
		return "insert into Customer_Product (id_customer, id_product) VALUES ('" +
		customer.getId() + "', '"+
		product.getId()+ "');";
	}
	
	/* Generates the String order for select Derby order in Customer table
	 * 	with given Customer fields in "where" clause
	 * @customer reference customer for "where" clause 
	 * @return String order
	 * */
	private String getOrderFindCustomer(Integer id) {	
		return "select * from Customer where id= " + id + ";";
	}
	
	/* Generates the String order for select Derby order in Product table
	 * 	with given Product fields in "where" clause
	 * @product reference product for "where" clause 
	 * @return String order
	 * */
	private String getOrderFindProduct(Integer id) {	
		return "select * from Product where id= " + id + ";";
	}

	/* Generates the String order for delete Derby order in Customer table
	 * 	with given Customer fields in "where" clause
	 * @id reference id for "where" clause 
	 * @return String order
	 * */
	private String getOrderDeleteCustomer(Integer id) {
		// Build select sentence for customer		
		return "delete from Customer where id= " + id + ";";
	}
	
	/* Generates the String order for delete Derby order in Product table
	 * 	with given Product fields in "where" clause
	 * @id reference id for "where" clause 
	 * @return String order
	 * */
	private String getOrderDeleteProduct(Integer id) {	
		return "delete from Product where id= " + id + ";";
	}
	
	/* Creates a Customer object with dummy and random attributes
	 * @return valid Customer object built with dummy values
	 * */
	private Customer buildRandomCustomer() {
		// Build sample customer
		Customer customer = new Customer();
		
		customer.setId(new Integer(new Integer(random.nextInt())));
		String randomString = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setName(randomString);
		randomString = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setLastname(randomString);
		randomString = Long.toString(Math.abs(random.nextLong()), 10);
		customer.setAddress(randomString);
		return customer;
	}
	
	/* Creates a Product object with dummy and random attributes
	 * @return valid Product object built with dummy values
	 * */
	private Product buildRandomProduct() {
		// Build sample product
		Product product = new Product();

		// Fill attributes with dummy and random strings
		product.setId(new Integer(new Integer(random.nextInt())));
		product.setPrice(random.nextFloat());
		String randomString = Long.toString(Math.abs(random.nextLong()), 10);
		product.setDescription(randomString);
		randomString = Long.toString(Math.abs(random.nextLong()), 10);
		product.setName(randomString);
		product.setValid(random.nextBoolean());		
		return product;
	}
	
	/* Tests CustomerDaoDerby.add function
	 *  In order to test ONLY CustomerDaoDerby "add" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testCustomerDaoDerbyAdd() throws SQLException, ClassNotFoundException {
		// Build reference customer
		Customer customer = buildRandomCustomer();

		// Customer dao
		CustomerDaoDerby customerDao = new CustomerDaoDerby();
		
		// Add customer to DB
		customerDao.add(customer);
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Exec reference query
		ResultSet res = con.createStatement().executeQuery(getOrderFindCustomer(customer.getId()));

		// Check customer added
		assertTrue(res.next());
		
		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteCustomer(customer.getId()));
		con.close();
	}
	
	/* Tests ProductDaoDerby.add function
	 *  In order to test ONLY ProductDaoDerby "add" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testProductDaoDerbyAdd() throws SQLException, ClassNotFoundException {
		// Build reference product
		Product product = buildRandomProduct();

		// Product dao
		ProductDaoDerby productDao = new ProductDaoDerby();
		
		// Add product to DB
		productDao.add(product);
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Exec reference query
		ResultSet res = con.createStatement().executeQuery(getOrderFindProduct(product.getId()));

		// Check customer added
		assertTrue(res.next());
		
		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteProduct(product.getId()));
		con.close();
	}
	
	/* Tests CustomerDaoDerby.delete function
	 *  In order to test ONLY CustomerDaoDerby "delete" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testCustomerDaoDerbyDelete() throws SQLException, ClassNotFoundException {
		// Build reference customer
		Customer customer = buildRandomCustomer();

		// Customer dao
		CustomerDaoDerby customerDao = new CustomerDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add customer to DB
		con.createStatement().executeUpdate(getOrderAddCustomer(customer));
		
		// Delete
		customerDao.delete(customer);

		// Exec reference query
		ResultSet res = con.createStatement().executeQuery(getOrderFindCustomer(customer.getId()));

		// Check customer deleted
		assertFalse(res.next());
		con.close();
	}
	
	/* Tests ProductDaoDerby.delete function
	 *  In order to test ONLY ProductDaoDerby "delete" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testProductDaoDerbyDelete() throws SQLException, ClassNotFoundException {
		// Build reference product
		Product product = buildRandomProduct();

		// Product dao
		ProductDaoDerby productDao = new ProductDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add product to DB
		con.createStatement().executeUpdate(getOrderAddProduct(product));
		
		// Delete
		productDao.delete(product);

		// Exec reference query
		ResultSet res = con.createStatement().executeQuery(getOrderFindProduct(product.getId()));

		// Check product deleted
		assertFalse(res.next());
		con.close();
	}
	
	/* Tests CustomerDaoDerby.find function
	 *  In order to test ONLY CustomerDaoDerby "find" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testCustomerDaoDerbyFind() throws SQLException, ClassNotFoundException {
		// Build reference customer
		Customer customer = buildRandomCustomer();

		// Customer dao
		CustomerDaoDerby customerDao = new CustomerDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add customer to DB
		con.createStatement().executeUpdate(getOrderAddCustomer(customer));

		// Exec reference query
		Customer customer_select = customerDao.find(customer.getId());

		// Check customer correctly selected
		assertNotNull(customer_select);
		assertEquals(customer_select.getName(), customer.getName());
		assertEquals(customer_select.getLastname(), customer.getLastname());
		assertEquals(customer_select.getAddress(), customer.getAddress());

		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteCustomer(customer.getId()));
		con.close();
	}
	
	/* Tests ProductDaoDerby.find function
	 *  In order to test ONLY ProductDaoDerby "find" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testProductDaoDerbyFind() throws SQLException, ClassNotFoundException {
		// Build reference product
		Product product = buildRandomProduct();

		// Product dao
		ProductDaoDerby productDao = new ProductDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add product to DB
		con.createStatement().executeUpdate(getOrderAddProduct(product));

		// Find product
		Product product_select = productDao.find(product.getId());
		
		// Check product correctly selected
		assertNotNull(product_select);
		assertEquals(product_select.getName(), product.getName());
		
		// Derby float precission differs from java one: compare just 4 #1 decimals 
		DecimalFormat df = new DecimalFormat("0.0000");		
		assertEquals(df.format(product_select.getPrice()), df.format(product.getPrice()));
		assertEquals(product_select.getDescription(), product.getDescription());
		assertEquals(product_select.getValid(), product.getValid());

		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteProduct(product.getId()));
		con.close();
	}
	
	/* Tests CustomerDaoDerby.update function
	 *  In order to test ONLY CustomerDaoDerby "update" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testCustomerDaoDerbyUpdate() throws SQLException, ClassNotFoundException {
		// Build reference customer
		Customer customer = buildRandomCustomer();

		// Customer dao
		CustomerDaoDerby customerDao = new CustomerDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add customer to DB
		con.createStatement().executeUpdate(getOrderAddCustomer(customer));

		// Exec reference query
		Customer customer_updated = buildRandomCustomer();
		customer_updated.setId(customer.getId());
		Customer customer_select = customerDao.update(customer_updated);

		// Check customer correctly selected
		assertNotNull(customer_select);
		assertEquals(customer_select.getName(), customer_updated.getName());
		assertEquals(customer_select.getLastname(), customer_updated.getLastname());
		assertEquals(customer_select.getAddress(), customer_updated.getAddress());

		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteCustomer(customer.getId()));
		con.close();
	}
	
	/* Tests ProductDaoDerby.update function
	 *  In order to test ONLY ProductDaoDerby "update" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testProductDaoDerbyUpdate() throws SQLException, ClassNotFoundException {
		// Build reference product
		Product product = buildRandomProduct();

		// Product dao
		ProductDaoDerby productDao = new ProductDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add product to DB
		con.createStatement().executeUpdate(getOrderAddProduct(product));

		// Update product (create a new one and override its id)
		Product product_updated = buildRandomProduct();
		product_updated.setId(product.getId());
		Product product_select = productDao.update(product_updated);

		// Check customer correctly selected
		assertNotNull(product_select);
		assertEquals(product_select.getName(), product_updated.getName());
		
		// Derby float precission differs from java one: compare just 4 #1 decimals 
		DecimalFormat df = new DecimalFormat("0.0000");

		assertEquals(df.format(product_select.getPrice()), df.format(product_updated.getPrice()));
		assertEquals(product_select.getDescription(), product_updated.getDescription());
		assertEquals(product_select.getValid(), product_updated.getValid());

		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteProduct(product.getId()));
		con.close();
	}

	/* Tests ProductDaoDerby.getValidProducts function
	 *  In order to test ONLY ProductDaoDerby "getValidProducts" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testCustomerDaoDerbyGetProductsForCustomer() throws SQLException, ClassNotFoundException {
		// Build reference products
		Product product1 = buildRandomProduct();
		Product product2 = buildRandomProduct();
		Product product3 = buildRandomProduct();
		
		// Build reference customer
		Customer customerA = buildRandomCustomer();
		Customer customerB = buildRandomCustomer();

		// Product and Customer daos
		ProductDaoDerby productDao = new ProductDaoDerby();
		CustomerDaoDerby customerDao = new CustomerDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add products and customers to DB
		con.createStatement().executeUpdate(getOrderAddProduct(product1));		
		con.createStatement().executeUpdate(getOrderAddProduct(product2));
		con.createStatement().executeUpdate(getOrderAddProduct(product3));
		
		con.createStatement().executeUpdate(getOrderAddCustomer(customerA));
		con.createStatement().executeUpdate(getOrderAddCustomer(customerB));

		// Add relations product1-customerA, product2-customerA, product3-customerB
		con.createStatement().executeUpdate(getOrderAddCustomerProduct(customerA, product1));
		con.createStatement().executeUpdate(getOrderAddCustomerProduct(customerA, product2));
		con.createStatement().executeUpdate(getOrderAddCustomerProduct(customerB, product3));

		// Find product
		List<Product> product_list = customerDao.getProductsForCustomer(customerA);
		
		// Check product correctly found
		assertEquals(product_list.size(), 2);
		Product reference = product_list.get(0);
		assertTrue(reference.getId().compareTo(product1.getId()) == 0 ||
				reference.getId().compareTo(product2.getId()) == 0 );
		reference = product_list.get(1);
		assertTrue(reference.getId().compareTo(product1.getId()) == 0 ||
				reference.getId().compareTo(product2.getId()) == 0 );

		// Remove elements
		con.createStatement().executeUpdate(getOrderDeleteProduct(product1.getId()));
		con.createStatement().executeUpdate(getOrderDeleteProduct(product2.getId()));
		con.createStatement().executeUpdate(getOrderDeleteProduct(product3.getId()));
		
		con.createStatement().executeUpdate(getOrderDeleteCustomer(customerA.getId()));
		con.createStatement().executeUpdate(getOrderDeleteCustomer(customerB.getId()));
		
		con.close();
	}
	
	/* Tests ProductDaoDerby.getValidProducts function
	 *  In order to test ONLY ProductDaoDerby "getValidProducts" functionality,
	 *  the rest of needed functions are executed directly
	 *  in the database
	 * */
	public void testProductDaoDerbyGetValidProducts() throws SQLException, ClassNotFoundException {
		// Build reference product
		Product productValid1 = buildRandomProduct();
		productValid1.setValid(true);
		Product productValid2 = buildRandomProduct();
		productValid2.setValid(true);
		Product productNoValid1 = buildRandomProduct();
		productNoValid1.setValid(false);

		// Product dao
		ProductDaoDerby productDao = new ProductDaoDerby();
		
		// Open a new connection to db
		Connection con = connectionDaoDerby.getConnection();
		
		// Add product to DB
		con.createStatement().executeUpdate(getOrderAddProduct(productValid1));
		con.createStatement().executeUpdate(getOrderAddProduct(productValid2));
		con.createStatement().executeUpdate(getOrderAddProduct(productNoValid1));

		// Find product
		List<Product> product_list = productDao.getValidProducts();
		
		// Check product correctly found
		assertEquals(product_list.size(), 2);
		Product reference = product_list.get(0);
		assertTrue(reference.getId().compareTo(productValid1.getId()) == 0 ||
				reference.getId().compareTo(productValid2.getId()) == 0 );
		reference = product_list.get(1);
		assertTrue(reference.getId().compareTo(productValid1.getId()) == 0 ||
				reference.getId().compareTo(productValid2.getId()) == 0 );

		// Remove result
		con.createStatement().executeUpdate(getOrderDeleteProduct(productValid1.getId()));
		con.createStatement().executeUpdate(getOrderDeleteProduct(productValid2.getId()));
		con.createStatement().executeUpdate(getOrderDeleteProduct(productNoValid1.getId()));
		con.close();
	}
}