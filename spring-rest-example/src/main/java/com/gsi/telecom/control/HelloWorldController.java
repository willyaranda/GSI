package com.gsi.telecom.control;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/test")
public class HelloWorldController {
	
	/*
	 * Log access
	 * */
	private static Logger log = Logger.getLogger(HelloWorldController.class);

	/*
	 * Application context (Bean access)
	 * */
	private WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();

	/*
	 * Customer DB access
	 * */
	private CustomerDao customerDao;
	
	// Test of ajax requesting a JSON list
    @RequestMapping(value = "/testAjaxJson", method = RequestMethod.GET)
	@ResponseBody
    public List<Customer> helloWorldControllerTestJSON() throws Exception {
    	log.debug("---------------------------------------Calling HelloWorldController");
    	
    	// Add dummy customers
    	Customer customerTest = new Customer();
    	customerTest.setId(1);
    	customerTest.setName("Alejandro");
    	customerDao.delete(customerTest);
    	customerDao.add(customerTest);
    	
    	customerTest.setId(2);
    	customerTest.setName("Manuel");
    	customerDao.delete(customerTest);
    	customerDao.add(customerTest);
    	
    	// Load customers and return a list with them
	   	List<Customer> listUser = new ArrayList<Customer>();
	   	listUser.add(customerDao.find(1));
	   	listUser.add(customerDao.find(2));

		// Not placed in the model neither interpreted as the view name
        return listUser;        
    }
	
	/*
	 * Default constructor
	 * */
	public HelloWorldController() {
		if(ctx.containsBean("customerDao")) {
			customerDao = (CustomerDao) ctx.getBean("customerDao");
			log.debug("--------------customerDao found");
		} else
			log.debug("--------------customerDao NOT found");
	}
}