package com.coderdot.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	
	
	@Id
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private LocalDate orderDate;

}
