package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gsi.telecom.dao.CustomerDao;
import com.gsi.telecom.data.Customer;
import com.gsi.telecom.data.Product;

public class CustomerDaoMySqlSpring implements CustomerDao {

	private ProductDaoMySqlSpring productDao = new ProductDaoMySqlSpring();
	
	private DataSource dataSource;
	
	public List<Product> getProductsForCustomer(Customer customer) {
		Connection con;
		List<Product> list = new ArrayList<Product>();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		try {
			String orden = "select id_product from Customer_Product where id_customer=" + customer.getId();			
			ResultSet res = con.createStatement().executeQuery(orden);
			
			int id_product;	
			while(res.next()) {
				id_product = res.getInt("id_product");
				list.add(productDao.find(id_product));
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void add(Customer customer) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}

		try {
			String orden = "insert into Customer (id, name, lastname, address) VALUES ('" +
						(customer.getId() != null? customer.getId(): " \" \"") + "', '"+
						(customer.getName() != null? customer.getName(): " \" \"") + "', '"+
						(customer.getLastname() != null? customer.getLastname() : " \"\" ") + "', '"+
						(customer.getAddress() != null? customer.getAddress(): " \"\" ") + "');";

			con.createStatement().executeUpdate(orden);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Customer customer) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}

		try {
			String orden = "delete from Customer where id=" + customer.getId();			
			con.createStatement().executeUpdate(orden);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Customer find(Integer customer_id) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		try {
			String orden = "select * from Customer where id=" + customer_id;			
			ResultSet res = con.createStatement().executeQuery(orden);
			if(!res.next())
				return null;
			
			Customer customer = new Customer(new Integer(res.getInt("id")), res.getString("name"), res.getString("lastname"), res.getString("address"));
			con.close();
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Customer update(Customer customer) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		try {
			String orden = "update Customer set "
				+ "name = '" + customer.getName() + "', "
				+ "lastname = '" + customer.getLastname() + "', "
				+ "address = '" + customer.getAddress() + "'"
				+" where id=" + customer.getId() + ";";			
			if(con.createStatement().executeUpdate(orden) != 1)
				return null;
			Customer customer_updated = this.find(customer.getId());
			con.close();
			return customer_updated;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ProductDaoMySqlSpring getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDaoMySqlSpring productDao) {
		this.productDao = productDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
