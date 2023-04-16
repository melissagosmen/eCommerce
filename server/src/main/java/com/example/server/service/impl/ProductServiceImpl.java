package com.example.server.service.impl;

import com.example.server.dto.ProductDto;
import com.example.server.entity.Product;
import com.example.server.repository.ProductRepository;
import com.example.server.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.server.dto.ProductDto.toDto;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void add(ProductDto productDto) {
        productRepository.save(productDto.toEntity());
    }

    @Override
    public void change(ProductDto productDto) {

    }

    @Override
    public void delete(long productId) {

    }

    @Override
    public ProductDto find(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return toDto(product.get());
    }

    @Override
    public List<ProductDto> list() {
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product: productRepository.findAll()){
            productDtoList.add(toDto(product));
        }
        return productDtoList;
    }



}
