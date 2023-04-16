package com.example.server.service.impl;

import com.example.server.dto.CartDto;
import com.example.server.dto.CheckoutDto;
import com.example.server.entity.Cart;
import com.example.server.enums.CartStatus;
import com.example.server.repository.CartRepository;
import com.example.server.repository.CategoryRepository;
import com.example.server.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public long add() {
        Cart cart = new Cart();
        cart.setCartStatus(CartStatus.NEW);

        return cartRepository.save(cart).getCartId();
    }

    @Override
    public Optional<Cart> find(long cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public long delete(long cartId) {
        cartRepository.deleteById(cartId);
        return cartId;
    }

    @Override
    public void checkout(CheckoutDto checkoutDto) {
        Cart cart = cartRepository.findById(checkoutDto.getCartId()).get();
        cart.setCustomerName(checkoutDto.getCustomerName());
        cart.setCardNumber(checkoutDto.getCardNumber());
        cart.setCartStatus(CartStatus.COMPLETED);
        cartRepository.save(cart);
    }
}
