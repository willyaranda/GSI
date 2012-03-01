package es.willyaranda.ej1.dao;


import java.util.List;

import es.willyaranda.ej1.data.Customer;

public interface CustomerDao extends BasicDao <Customer> {
	public List getProductsForCustomer(Customer customer);

}
