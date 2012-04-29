package com.gsi.telecom.dao;

import java.sql.SQLException;

import com.gsi.telecom.data.BasicData;

/**
 * Interface that has all methods that must be implemented by all classes
 * implementing this interface.
 * <p>
 * 
 * @author willyaranda
 * 
 * @param <T>
 */
public interface BasicDao<T extends BasicData> {

	/**
	 * Insert an object to the DB
	 * 
	 * @param basic
	 *            - the object to add to the DB
	 * @throws SQLException
	 */
	public void add(T basic) throws SQLException;

	/**
	 * Delete an object from the DB
	 * 
	 * @param basic
	 *            - the object to delete from the DB
	 * @throws SQLException
	 */
	public void delete(T basic) throws SQLException;

	/**
	 * Selects (find) and returns an object with the <code>id</code> in the
	 * database
	 * 
	 * @param id
	 *            - the identifier to return
	 * @return the object returned by the DB
	 * @throws SQLException
	 */
	public T select(Integer id) throws SQLException;

	/**
	 * Updates and returns the object with the <code>id</code>
	 * 
	 * @param basic
	 *            - the object to update in the DB
	 * @return the same object
	 * @throws SQLException
	 */
	public T update(T basic) throws SQLException;
}
