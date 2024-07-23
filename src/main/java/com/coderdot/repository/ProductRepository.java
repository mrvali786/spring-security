package com.coderdot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderdot.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
