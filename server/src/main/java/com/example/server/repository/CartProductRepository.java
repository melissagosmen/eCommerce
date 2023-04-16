package com.example.server.repository;

import com.example.server.dto.CartProductDto;
import com.example.server.entity.CartProduct;
import com.example.server.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    public void deleteByCartIdAndProductId(long cartId, long productId);

    public Optional<CartProduct> findByCartIdAndProductId(long cartId, long productId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update CartProduct cp set cp.salesQuantity = :salesQuantity where cp.cartProductId = :cartProductId")
    public void updateSalesQuantity(@Param("cartProductId") long cartProductId,@Param("salesQuantity") double salesQuantity);

    public List<CartProduct> getCartProductsByCartId(long cartId);

}

