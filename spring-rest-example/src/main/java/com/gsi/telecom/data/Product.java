package com.gsi.telecom.data;

public class Product implements BasicData{

	private Integer id;
	private String name;
	private Float price;
	private String description;
	private boolean valid;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Product(Integer id, String name, Float price, String description, boolean valid) {
		super();
		this.id = id;
		this.price = price;
		this.description = description;
		this.name = name;
		this.valid = valid;
	}

	public Product() {
		super();
	}

}
