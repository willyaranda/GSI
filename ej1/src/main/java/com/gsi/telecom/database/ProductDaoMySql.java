package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gsi.telecom.dao.ProductDao;
import com.gsi.telecom.data.Product;

public class ProductDaoMySql extends ConnectionDaoMySql implements ProductDao {

	@Override
	public void add(Product basic) throws SQLException {
		Connection conn = getConnection();
		int valid = basic.getValid() ? 1 : 0;
		String orden = "INSERT INTO Product (id, name, price, valid, description) VALUES ("
				+ "'"
				+ basic.getId()
				+ "', '"
				+ basic.getName()
				+ "', '"
				+ basic.getPrice()
				+ "', '"
				+ valid
				+ "', '"
				+ basic.getDescription() + "')";
		conn.createStatement().executeUpdate(orden);
		conn.close();
	}

	@Override
	public void delete(Product basic) throws SQLException {
		Connection conn = getConnection();
		try {
			String orden = "delete from Product where id=" + basic.getId();
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
			String orden = "select * from Product p where valid=1 order by p.id";
			rs = conn.createStatement().executeQuery(orden);
			if (rs != null) {
				while (rs.next()) {
					Integer id = rs.getInt("id");
					String name = rs.getString("name");
					Float price = rs.getFloat("price");
					Boolean valid = rs.getBoolean("valid");
					String description = rs.getString("description");
					Product prod = new Product();
					prod.setId(id);
					prod.setName(name);
					prod.setPrice(price);
					prod.setValid(valid);
					prod.setDescription(description);
					if (valid) {
						list.add(prod);
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product select(Integer id) throws SQLException {
		Connection conn = getConnection();
		Product prod = null;
		ResultSet rs = null;
		try {
			String orden = "select * from Product where id=" + id + ";";
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
	public Product update(Product basic) throws SQLException {
		Connection conn = getConnection();
		// We suppose that the product IS on the database
		try {
			// id, name, price, valid, description
			int valid = basic.getValid() ? 1 : 0;
			String orden = "UPDATE Product set name='" + basic.getName()
					+ "', " + "price='" + basic.getPrice() + "', " + "valid='"
					+ valid + "', " + "description='" + basic.getDescription()
					+ "';";
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return basic;
	}

}
