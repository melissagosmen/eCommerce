package com.example.server.dto;

import com.example.server.entity.Category;
import com.example.server.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

    private long categoryId;
    private String categoryName;
    private List<ProductDto> productList;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDto> productList) {
        this.productList = productList;
    }

    public Category toEntity(){
        Category category = new Category();
        category.setCategoryId(this.getCategoryId());
        category.setCategoryName(this.getCategoryName());

        List<Product> products = new ArrayList<>();
        for(ProductDto productDto : this.getProductList()){
            products.add((productDto.toEntity()));
        }

        category.setProductList(products);
        return category;
    }

    public static CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());

        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : category.getProductList()){
            productDtos.add(ProductDto.toDto(product));
        }

        categoryDto.setProductList(productDtos);
        return categoryDto;
    }
}
