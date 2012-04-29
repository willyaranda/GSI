package com.gsi.telecom.data;

/**
 * This class implements the BasicData interface
 * 
 * @author willyaranda
 * 
 */
public class Customer implements BasicData {

	/**
	 * The value to search in the DB
	 */
	private Integer id;
	private String name;
	private String lastname;
	private String address;

	/**
	 * Empty constructor
	 */
	public Customer() {
		// Empty
	}

	/**
	 * Copy constructor
	 * 
	 * @param cust1
	 */
	public Customer(Customer cust1) {
		this.id = cust1.getId();
		this.name = cust1.getName();
		this.lastname = cust1.getLastname();
		this.address = cust1.getAddress();
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 * @param name
	 * @param lastname
	 * @param address
	 */
	public Customer(Integer id, String name, String lastname, String address) {
		this.id = id;
		this.name = name;
		this.lastname = address;
		this.address = address;
	}

	/**
	 * Returns the address
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	@Override
	public Integer getId() {
		return id;
	}

	/**
	 * Returns the lastname
	 * 
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Returns the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the lastname
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Sets the name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Prettyprint any Customer object
	 * 
	 * @return the string prettyprinted
	 */
	@Override
	public String toString() {
		return new String("ID=" + this.getId() + " -- " + "Name="
				+ this.getName() + " -- " + "LastName=" + this.getLastname()
				+ " -- " + "Address=" + this.getAddress());
	}

}
