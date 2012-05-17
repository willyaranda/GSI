package com.gsi.telecom.control;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gsi.telecom.dao.CustomerDao;
import com.gsi.telecom.data.Customer;

/**
 *  Controller mapping request for tests
 *    
 * @author Noelia Morón Tabernero mtnoelia@gmail.com
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	 * Log access
	 * */
	private static Logger log = Logger.getLogger(CustomerController.class);

	/*
	 * Application context (Bean access)
	 * */
	private WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();

	/*
	 * Customer DB access
	 * */
	private CustomerDao customerDao;
	
	/*
	 * Default constructor
	 * */
	public CustomerController() {
		customerDao = (CustomerDao) ctx.getBean("customerDao");		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable Integer id) {
		Customer customer = new Customer();
		customer.setId(id);
		customerDao.delete(customer);
	}
}