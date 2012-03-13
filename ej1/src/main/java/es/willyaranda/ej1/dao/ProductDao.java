package es.willyaranda.ej1.dao;

import java.util.List;

import es.willyaranda.ej1.data.Product;

public interface ProductDao extends BasicDao<Product> {
	public List getValidProducts();

}
