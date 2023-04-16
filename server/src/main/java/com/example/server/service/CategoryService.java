package com.example.server.service;

import com.example.server.dto.CategoryDto;
import com.example.server.dto.ProductDto;
import com.example.server.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(CategoryDto categoryDto);
    void change(CategoryDto categoryDto);
    void delete(long categoryId);
    void find(long categoryId);
    List<CategoryDto> listCategory();
    List<ProductDto> listProductsByCategoryId(long categoryId);
}
