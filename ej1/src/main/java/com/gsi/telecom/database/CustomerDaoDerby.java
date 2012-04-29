package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gsi.telecom.dao.CustomerDao;
import com.gsi.telecom.data.Customer;
import com.gsi.telecom.data.Product;

public class CustomerDaoDerby extends ConnectionDaoDerby implements CustomerDao {

	@Override
	public void add(Customer customer) throws SQLException {
		Connection conn = getConnection();
		String orden = "INSERT INTO Customer (id, name, lastname, address) VALUES ("
				+ customer.getId()
				+ ", '"
				+ customer.getName()
				+ "', '"
				+ customer.getLastname()
				+ "', '"
				+ customer.getAddress()
				+ "')";
		conn.createStatement().executeUpdate(orden);
		conn.close();
	}

	@Override
	public void delete(Customer customer) throws SQLException {
		Connection conn = getConnection();
		try {
			String orden = "delete from Customer where id=" + customer.getId();
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Wrapper
	public Customer find(Integer id) throws SQLException {
		return select(id);
	}

	public List<Product> getProductsForCustomer(Customer customerA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer select(Integer id) throws SQLException {
		Connection conn = getConnection();
		Customer cust = null;
		ResultSet rs = null;
		try {
			String orden = "select * from Customer where id=" + id;
			rs = conn.createStatement().executeQuery(orden);
			// We need to iterate to get the first (and unique) result
			rs.next();
			Integer idd = rs.getInt("id");
			String name = rs.getString("name");
			String lastname = rs.getString("lastname");
			String address = rs.getString("address");
			cust = new Customer();
			cust.setId(idd);
			cust.setName(name);
			cust.setLastname(lastname);
			cust.setAddress(address);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public Customer update(Customer customer) throws SQLException {
		Connection conn = getConnection();
		// We suppose that the customer IS on the database
		try {
			String orden = "UPDATE Customer set name='" + customer.getName()
					+ "', " + "lastname='" + customer.getLastname() + "', "
					+ "address='" + customer.getAddress() + "'";
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
