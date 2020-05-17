package com.productorderservice.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productorderservice.entity.Orders;
import com.productorderservice.entity.products;
import com.productorderservice.repository.OrdersRepo;
import com.productorderservice.repository.ProductRepo;

import javassist.NotFoundException;

@RestController
@RequestMapping("ordering")
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	OrdersRepo ordersRepo;

	
	@GetMapping("/{username}")
	public List<Orders> getOrderHistory(@PathVariable String username){
		System.out.println("username -> " + username);
		List<Orders> list= null;
		list = ordersRepo.findByusername(username);
		return list;
		
	}
	
	@PostMapping
	public List<Orders> placeOrder(@RequestBody List<Orders> orderList, @RequestHeader(value="Authorization") String authorizationHeader) throws NotFoundException 
	{
		for( Orders order:orderList) {
			products product =productRepo.findByproductnameIgnoreCase(order.getProductname());
			if(product != null) {
				order.setTotalcost(product.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
			}else {
				throw new NotFoundException("Invalid Product Name -> " + order.getProductname());
			}
		}
		ordersRepo.saveAll(orderList);
		return orderList;
	}
	
	@GetMapping("/products")
	public List<products> getproducts(){
		
		return productRepo.findAll();
		
	}

}
