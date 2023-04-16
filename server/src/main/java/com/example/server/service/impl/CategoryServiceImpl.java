package com.example.server.service.impl;

import com.example.server.dto.CategoryDto;
import com.example.server.dto.ProductDto;
import com.example.server.entity.Category;
import com.example.server.entity.Product;
import com.example.server.repository.CategoryRepository;
import com.example.server.service.CategoryService;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void add(CategoryDto categoryDto) {
        categoryRepository.save(categoryDto.toEntity());
    }

    @Override
    public void change(CategoryDto categoryDto) {

    }

    @Override
    public void delete(long categoryId) {

    }

    @Override
    public void find(long categoryId) {

    }

    @Override
    public List<CategoryDto> listCategory() {
        List<CategoryDto> categoryList = new ArrayList<>();
        for(Category category: categoryRepository.findAll()){
            categoryList.add(CategoryDto.toDto(category));
        }
        return categoryList;
    }
    @Override
    public List<ProductDto> listProductsByCategoryId(long categoryId){
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product: categoryRepository.findProductsByCategoryId(categoryId)){
            productDtoList.add(ProductDto.toDto(product));
        }
        return productDtoList;
    }



}
