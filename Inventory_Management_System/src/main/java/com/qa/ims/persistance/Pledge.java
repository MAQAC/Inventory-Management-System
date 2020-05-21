package com.qa.ims.persistance;

import java.math.BigDecimal;
import java.sql.Date;

public class Pledge {

	private int id;
	private int custid;
	private Date pledgedate;
	private BigDecimal price;
	
	public Pledge() {
		
	}
	
	public Pledge(int id, int custid, Date pledgedate, BigDecimal price) {
		this.id = id;
		this.custid = custid;
		this.pledgedate = pledgedate;
		this.price = price;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public Date getPledgedate() {
		return pledgedate;
	}

	public void setPledgedate(Date pledgeDateTemp) {
		this.pledgedate = pledgeDateTemp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal priceTemp) {
		this.price = priceTemp;
	}

	@Override
	public String toString() {
		return "Pledge [id=" + id + ", custid=" + custid + ", pledgedate=" + pledgedate + ", price=" + price + "]";
	}
	
	
	
}
	

