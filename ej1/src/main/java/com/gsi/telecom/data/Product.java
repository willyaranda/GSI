package com.gsi.telecom.data;

public class Product implements BasicData {

	private Integer id;

	private String name;

	private Float price;

	private Boolean valid;

	private String description;

	public String getDescription() {
		return description;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return new String("ID=" + this.getId() + " -- " + "Name="
				+ this.getName() + " -- " + "Price=" + this.getPrice() + " -- "
				+ "Valid=" + this.getValid() + " -- " + "Desc="
				+ this.getDescription());
	}
}
