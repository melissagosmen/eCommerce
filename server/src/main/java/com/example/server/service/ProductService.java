package com.example.server.service;

import com.example.server.dto.ProductDto;
import com.example.server.entity.Product;

import java.util.List;

public interface ProductService {
    void add(ProductDto productDto);
    void change(ProductDto productDto);
    void delete(long productId);
    ProductDto find(long productId);
    List<ProductDto> list();
}
