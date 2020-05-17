package com.productorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productorderservice.entity.products;

public interface ProductRepo extends JpaRepository<products, Long>{
	
  products findByproductnameIgnoreCase(String productname);
}
