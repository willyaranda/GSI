package es.willyaranda.ej1.database;

import java.util.HashMap;
import java.util.List;

import es.willyaranda.ej1.dao.ProductDao;
import es.willyaranda.ej1.data.Product;

public class ProductDaoHash implements ProductDao {

	private HashMap<Integer, Product> productTable;

	public ProductDaoHash() {
		productTable = new HashMap<Integer, Product>();
	}

	@Override
	public List getValidProducts() {
		return null;
	}

	@Override
	public void delete(Product basic) {
		productTable.remove(basic.getID());
	}

	@Override
	public Product find(Integer id) {
		return this.productTable.get(id);
	}

	@Override
	public void insert(Product basic) {
		productTable.put(basic.getID(), basic);
	}

	@Override
	public Product select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product basic) {
		productTable.put(basic.getID(), basic);
	}
}
