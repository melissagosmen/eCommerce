package com.example.server.dto;

import com.example.server.entity.Category;
import com.example.server.entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ProductDto {

    private long productId;
    private String productName;
    private double salesPrice;
    private long categoryId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Product toEntity(){
        Product product = new Product();
        product.setProductId(this.getProductId());
        product.setProductName(this.getProductName());
        product.setSalesPrice(this.getSalesPrice());

        Category category = new Category();
        category.setCategoryId(this.getCategoryId());

        product.setCategory(category);
        return product;
    }

    public static ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        productDto.setCategoryId(product.getCategory().getCategoryId());

        return productDto;
    }
}
