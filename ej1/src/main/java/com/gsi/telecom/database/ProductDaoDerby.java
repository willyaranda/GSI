package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gsi.telecom.dao.ProductDao;
import com.gsi.telecom.data.Product;

/**
 * Implements the ProductDao interface for Derby DB
 * 
 * @author willyaranda
 * 
 */
public class ProductDaoDerby extends ConnectionDaoDerby implements ProductDao {

	@Override
	public void add(Product product) throws SQLException {
		Connection conn = getConnection();
		int valid = product.getValid() ? 1 : 0;
		String orden = "INSERT INTO Product (id, name, price, valid, description) VALUES ("
				+ product.getId()
				+ ", '"
				+ product.getName()
				+ "', "
				+ product.getPrice()
				+ ", "
				+ valid
				+ ", '"
				+ product.getDescription() + "')";
		System.out.println("Orden INSERT --> " + orden);
		conn.createStatement().executeUpdate(orden);
		conn.close();
	}

	@Override
	public void delete(Product product) throws SQLException {
		Connection conn = getConnection();
		try {
			String orden = "DELETE from Product where id=" + product.getId();
			System.out.println("Orden DELETE --> " + orden);
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Wrapper
	public Product find(Integer id) throws SQLException {
		return select(id);
	}

	@Override
	public List<Product> getValidProducts() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			// Let's select all valid products
			String orden = "SELECT * from Product p where valid=1 order by p.id";
			System.out.println("Orden getValidProducts--> " + orden);
			rs = conn.createStatement().executeQuery(orden);
			if (rs != null) {
				// And create them
				while (rs.next()) {
					Integer id = rs.getInt("id");
					String name = rs.getString("name");
					Float price = rs.getFloat("price");
					Boolean valid = rs.getBoolean("valid");
					String description = rs.getString("description");
					// Creating Product
					Product prod = new Product();
					prod.setId(id);
					prod.setName(name);
					prod.setPrice(price);
					prod.setValid(valid);
					prod.setDescription(description);
					if (valid) {
						// And adding it if only is valid
						list.add(prod);
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Return the valid products in a list
		return list;
	}

	@Override
	public Product select(Integer id) throws SQLException {
		Connection conn = getConnection();
		Product prod = null;
		ResultSet rs = null;
		try {
			String orden = "SELECT * from Product where id=" + id;
			System.out.println("Orden SELECT --> " + orden);
			rs = conn.createStatement().executeQuery(orden);
			// We need to iterate to get the first (and unique) result
			rs.next();
			Integer idd = rs.getInt("id");
			String name = rs.getString("name");
			Float price = rs.getFloat("price");
			Boolean valid = rs.getBoolean("valid");
			String description = rs.getString("description");
			prod = new Product();
			prod.setId(idd);
			prod.setName(name);
			prod.setPrice(price);
			prod.setValid(valid);
			prod.setDescription(description);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public Product update(Product product) throws SQLException {
		Connection conn = getConnection();
		// We suppose that the product IS on the database
		try {
			// id, name, price, valid, description
			int valid = product.getValid() ? 1 : 0;
			String orden = "UPDATE Product set name='" + product.getName()
					+ "', " + "price=" + product.getPrice() + ", " + "valid="
					+ valid + ", " + "description='" + product.getDescription()
					+ "' where id=" + product.getId();
			System.out.println("Orden UPDATE --> " + orden);
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
}
