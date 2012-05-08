package com.gsi.telecom;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gsi.telecom.database.ConnectionDaoMySqlSpring;

import junit.framework.TestCase;

public class TestConnectionDaoMySqlSpring extends TestCase {
	
	private ConnectionDaoMySqlSpring connectionDao;
    protected void setUp() throws Exception {
    	//connectionDao.setDatabase(database);
    	//connectionDao.setPassword(password);
    	//connectionDao.setUser(user);
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
    	connectionDao = (ConnectionDaoMySqlSpring) ctx.getBean("connectionDao");
    }
    
    protected void tearDown() {
    	// TODO
    }
    
    public void testConnection() throws SQLException, ClassNotFoundException {
    	Connection con = connectionDao.getConnection();
    	
    	connectionDao.closeConnection(con);
    }
}
