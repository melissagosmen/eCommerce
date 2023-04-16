package com.example.server.controller;

import com.example.server.dto.CategoryDto;
import com.example.server.dto.ProductDto;
import com.example.server.repository.ProductRepository;
import com.example.server.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public ProductDto find(@PathVariable("productId") long productId){
        return productService.find(productId);
    }

}
