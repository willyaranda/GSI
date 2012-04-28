package com.gsi.telecom.data;

public class Customer implements BasicData {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private Integer id;
	private String name;
	private String lastname;
	private String address;
	
	@Override
	public String toString() {
		return new String("ID=" + this.getId() + " -- " +
						  "Name=" + this.getName() + " -- " +
						  "LastName=" + this.getLastname() + " -- " +
						  "Address=" + this.getAddress());
	}
	
}
