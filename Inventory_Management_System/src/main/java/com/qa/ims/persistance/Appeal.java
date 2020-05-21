package com.qa.ims.persistance;

import java.math.BigDecimal;

public class Appeal {

	int id;
	private String name;
	private String region;
	private BigDecimal price;
	
	public Appeal() {

	}
	
	public Appeal(int id, String name, String region, BigDecimal price)  {
		this.id = id;
		this.name = name;
		this.region = region;
		this.price = price;
	}
		
	//view appeals available
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Appeal [id=" + id + ", name=" + name + ", region=" + region + ", price="
				+ price + "]";
	}


	
}


