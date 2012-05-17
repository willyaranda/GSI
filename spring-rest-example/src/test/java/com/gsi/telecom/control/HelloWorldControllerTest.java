package com.gsi.telecom.control;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

public class HelloWorldControllerTest extends TestCase {
	/*
	 * REST interface
	 * */
	private RestTemplate restTemplate = new RestTemplate();
	
	/*
	 * URL "of helloworld" service
	 * */
	private String host = "http://localhost:8080/spring-rest-example-1.0/rest/test";
	
	/*
	 * Test log access
	 * */
	private static final Logger log = Logger.getLogger(HelloWorldControllerTest.class);
	
	/*
	 * Test HTTP not found error is properly returned for wrong URL
	 * */
	public void testGetNotFound() {
		
		String url = "http://localhost/spring-rest-example-1.0/rest/helloWorlFake";
		
		try {
			// Http request: url + GET
			String dataResponse = restTemplate.getForObject(url, String.class);
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		} catch(Exception e) {
			fail("this isn't the expected exception: "+e.getMessage());
		}
	}
	
	/*
	 * Test expected HTTP response is properly returned for right URL
	 * */
	public void testHelloWorldGet() {
		
		String url = host + "/testAjaxJson";
		
		try {
			// Http request: url + GET
			String dataResponse = restTemplate.getForObject(url, String.class);
		} catch (HttpClientErrorException e) {
			fail("this isn't the expected exception: "+e.getMessage());
		} catch(Exception e) {
			fail("this isn't the expected exception: "+e.getMessage());
		}
		assertTrue(true);
	}
}
