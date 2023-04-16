package com.example.server.service;

import com.example.server.dto.CartDto;
import com.example.server.dto.CategoryDto;
import com.example.server.dto.CheckoutDto;
import com.example.server.entity.Cart;

import java.util.Optional;

public interface CartService  {
    long add();
    Optional<Cart> find(long cartId);
    long delete(long cartId);
    void checkout(CheckoutDto checkoutDto);

}
