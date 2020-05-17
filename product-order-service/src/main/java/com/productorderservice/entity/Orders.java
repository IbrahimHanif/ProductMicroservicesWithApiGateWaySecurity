package com.productorderservice.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Orders {
	//id,user_name,transaction_token, session_token,product_name, price,quantity

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="product_name")
	private String productname;
	
	private BigDecimal totalcost;
	
	private Integer quantity;
	
	private String orderdate;
	
	@Transient
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	


	public Orders() {
		this.totalcost = BigDecimal.valueOf(1000);
		this.orderdate =formatter.format(new Date());
	}

	public Orders(String username, String productname,
			BigDecimal price, Integer quantity) {
		super();
		this.productname = productname;
		this.quantity = quantity;
		this.totalcost = BigDecimal.valueOf(1000);
		this.orderdate =formatter.format(new Date());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(BigDecimal totalcost) {
		this.totalcost = totalcost != null?totalcost:BigDecimal.valueOf(1000);
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate =orderdate != null?orderdate:formatter.format(new Date());
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", username=" + username + ", productname=" + productname + ", totalcost="
				+ totalcost + ", quantity=" + quantity + ", orderdate=" + orderdate + "]";
	}
	
	
	

}
