package com.coderdot.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.coderdot.dto.ProductDto;
import com.coderdot.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto signUpDto);
    
    List<ProductDto> toProductDtos(List<Product> products);

}
