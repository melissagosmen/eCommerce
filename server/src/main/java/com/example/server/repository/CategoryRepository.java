package com.example.server.repository;

import com.example.server.entity.Category;
import com.example.server.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select s.productList from Category s where s.categoryId = :categoryId")
    public Iterable<Product> findProductsByCategoryId(
            @Param("categoryId") double categoryId);
}
