package com.gsi.telecom.data;

public class Customer implements BasicData {

	private Integer id;

	private String name;

	private String lastname;

	private String address;

	public String getAddress() {
		return address;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new String("ID=" + this.getId() + " -- " + "Name="
				+ this.getName() + " -- " + "LastName=" + this.getLastname()
				+ " -- " + "Address=" + this.getAddress());
	}

}
