package com.productorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productorderservice.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long>{
	
	List<Orders> findByusername(String username);

}
