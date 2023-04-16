package com.example.server.service;

import com.example.server.dto.CartProductDto;
import com.example.server.entity.Cart;
import com.example.server.entity.CartProduct;

import java.util.List;
import java.util.Optional;

public interface CartProductService {
    void add(CartProductDto cartProductDto);
    void remove(long cartId, long productId);
    Optional<CartProduct> findByCartIdAndProductId(long cartId, long productId);
    void update(long cartProductId, double salesQuantity);
    List<CartProductDto> getCartProductList(long cartId);

}
