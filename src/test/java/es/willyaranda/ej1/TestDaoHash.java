package es.willyaranda.ej1;

import es.willyaranda.ej1.data.Product;
import es.willyaranda.ej1.database.ProductDaoHash;
import junit.framework.TestCase;

public class TestDaoHash extends TestCase {
	
	public void testProductDaoHashInsert() {
		Product product = new Product();
		product.setID(1);
		
		ProductDaoHash tablaHash = new ProductDaoHash();
		tablaHash.insert(product);
		assertEquals(product, tablaHash.find(1));
	}

}
