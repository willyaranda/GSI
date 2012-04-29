package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gsi.telecom.dao.CustomerDao;
import com.gsi.telecom.dao.ProductDao;
import com.gsi.telecom.data.Product;

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
		conn.createStatement().executeUpdate(orden);
		conn.close();
	}
	
	@Override
	public void delete(Product product) throws SQLException {
		Connection conn = getConnection();
		try {
			String orden = "delete from Product where id=" + product.getId();
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Wrapper
	public Product find(Integer id) throws SQLException {
		return select(id);
	}

	public List<Product> getValidProducts() {
		// TODO Auto-generated method stub
		return null;
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
					+ valid + ", " + "description='" + product.getDescription();
			conn.createStatement().executeUpdate(orden);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product select(Integer id) throws SQLException {
		Connection conn = getConnection();
		Product prod = null;
		ResultSet rs = null;
		try {
			String orden = "select * from Product where id=" + id;
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

}
