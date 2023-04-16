package com.example.server.controller;

import com.example.server.dto.CategoryDto;
import com.example.server.dto.ProductDto;
import com.example.server.entity.Category;
import com.example.server.repository.CategoryRepository;
import com.example.server.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> listCategory(){
        return categoryService.listCategory();
    }

    @GetMapping("/products/{categoryId}")
    public List<ProductDto> listProductsByCategoryId(@PathVariable("categoryId") long categoryId){
        return categoryService.listProductsByCategoryId(categoryId);
    }
}
