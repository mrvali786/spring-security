package com.coderdot.dto;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	
	
	@Id
	private Integer id;
	
	private String name;
	
	private Double price;
	
	private LocalDate orderDate;

}
