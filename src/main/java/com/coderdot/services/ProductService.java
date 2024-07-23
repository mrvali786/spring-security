package com.coderdot.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderdot.dto.ProductDto;
import com.coderdot.entities.Product;
import com.coderdot.mappers.ProductMapper;
import com.coderdot.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	private final ProductMapper productMapper;

	public List<ProductDto> list() {
		List<Product> list = productRepository.findAll();
		
		List<ProductDto> listDtos=productMapper.toProductDtos(list);

		return listDtos;
	}

}
