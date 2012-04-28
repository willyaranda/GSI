package com.gsi.telecom.data;

public class Product implements BasicData {

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

	public Float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private Integer id;
	private String name;
	private Float price;
	private Boolean valid;
	private String description;
	
	@Override
	public String toString() {
		return new String("ID=" + this.getId() + " -- " +
						  "Name=" + this.getName() + " -- " +
						  "Price=" + this.getPrice() + " -- " +
						  "Valid=" + this.getValid() + " -- " + 
						  "Desc=" + this.getDescription());
	}
}
