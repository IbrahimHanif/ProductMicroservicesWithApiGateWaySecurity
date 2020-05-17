package com.productorderservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class products {
	//id,user_name,transaction_token, session_token,product_name, price,quantity

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="product_name")
	private String productname;
	
	private BigDecimal price;
	
	public products() {	}

	public products(String productname,
			BigDecimal price) {
		super();
		this.productname = productname;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "ProductOrder [id=" + id + ", productname=" + productname + ", price=" + price  +"]";
	}
}
