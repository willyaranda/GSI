package com.gsi.telecom.data;

/**
 * Basic data that all classes implementing this interface must have (an ID for
 * the DB)
 * 
 * @author willyaranda
 * 
 */
public interface BasicData {
	/**
	 * Returns the <code>id</code> of the object in the DB
	 * 
	 * @return the <code>id</code>
	 */
	Integer getId();

	/**
	 * Sets the ID for the DB index
	 * 
	 * @param id
	 *            - the ID for storing in the DB
	 */
	void setId(Integer id);
}
