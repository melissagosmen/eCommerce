package com.example.server.dto;

import com.example.server.entity.Cart;
import com.example.server.enums.CartStatus;

public class CartDto {
    private long cartId;
    private String customerName;
    private long cartNumber;
    private CartStatus cartStatus;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(long cartNumber) {
        this.cartNumber = cartNumber;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }

    public Cart toEntity(){
        Cart cart = new Cart();
        cart.setCartStatus(this.getCartStatus());
        cart.setCartId(this.getCartId());
        cart.setCardNumber(this.getCartNumber());
        cart.setCustomerName(this.getCustomerName());

        return cart;
    }

    public static CartDto toDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setCartStatus(cart.getCartStatus());
        cartDto.setCartId(cart.getCartId());
        cartDto.setCartNumber(cart.getCardNumber());
        cartDto.setCustomerName(cart.getCustomerName());

        return cartDto;
    }
}
