package com.gsi.telecom.data;

public class Customer implements BasicData{
	private Integer id;
	private String name;
	private String lastname;
	private String address;

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(Integer id, String name, String lastname, String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
	}
	public Customer() {
		super();
	}
	
}
