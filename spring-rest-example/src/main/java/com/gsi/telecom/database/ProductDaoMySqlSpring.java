package com.gsi.telecom.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gsi.telecom.dao.ProductDao;
import com.gsi.telecom.data.Product;

public class ProductDaoMySqlSpring implements ProductDao {

	private DataSource dataSource;

	public List<Product> getValidProducts() {
		Connection con;
		List<Product> listValid = new ArrayList<Product>();
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		try {
			String orden = "select * from Product where valid='1'";			
			ResultSet res = con.createStatement().executeQuery(orden);
			while(res.next()) {
				Product product = new Product(new Integer(res.getInt("id")),
										res.getString("name"),
										res.getFloat("price"),
										res.getString("description"),
										res.getBoolean("valid"));
				listValid.add(product);
			}
			con.close();
			return listValid;
		} catch (SQLException e) {
			e.printStackTrace();
			return listValid;
		}
	}

	public void add(Product product) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		try {
			String order = "insert into Product (id, name, price, description, valid) VALUES ('" +
			(product.getId() != null? product.getId(): " \" \"") + "', '"+
			(product.getName() != null? product.getName(): " \" \"") + "', '"+
			(product.getPrice() != null? product.getPrice(): " \" \"") + "', '"+
			(product.getDescription() != null? product.getDescription() : " \"\" ") + "', "+
			(product.getValid()? "'1'": "'0'")+");";

			con.createStatement().executeUpdate(order);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Product product) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		try {
			String orden = "delete from Product where id=" + product.getId();			
			con.createStatement().executeUpdate(orden);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Product find(Integer product_id) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		try {
			String orden = "select * from Product where id=" + product_id;			
			ResultSet res = con.createStatement().executeQuery(orden);
			if(!res.next())
				return null;
			
			Product product = new Product(new Integer(res.getInt("id")),
										res.getString("name"),
										res.getFloat("price"),
										res.getString("description"),
										res.getBoolean("valid"));
			con.close();
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product update(Product product) {
		Connection con;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		try {
			String order = "update Product set "
				+ "name = '" + product.getName() + "', "
				+ "description = '" + product.getDescription() + "', "
				+ "price = '" + product.getPrice() + "', "
				+ "valid = '" + (product.getValid()? "1":"0") + "'"
				+" where id='" + product.getId() + "';";
			if(con.createStatement().executeUpdate(order) != 1)
				return null;
			Product product_updated = this.find(product.getId());
			con.close();
			return product_updated;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
