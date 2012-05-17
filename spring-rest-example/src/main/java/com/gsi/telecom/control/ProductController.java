package com.gsi.telecom.control;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gsi.telecom.dao.ProductDao;

/**
 *  Controller mapping request for tests
 *    
 * @author Noelia Morón Tabernero mtnoelia@gmail.com
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	/*
	 * Log access
	 * */
	private static Logger log = Logger.getLogger(ProductController.class);

	/*
	 * Application context (Bean access)
	 * */
	private WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();

	/*
	 * Customer DB access
	 * */
	private ProductDao productDao;
	
	/*
	 * Default constructor
	 * */
	public ProductController() {
		productDao = (ProductDao) ctx.getBean("productDao");		
	}
}