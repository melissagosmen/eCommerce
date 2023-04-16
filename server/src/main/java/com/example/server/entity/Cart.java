package com.example.server.entity;

import com.example.server.enums.CartStatus;
import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    private String customerName;
    private long cardNumber;
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

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cartNumber) {
        this.cardNumber = cartNumber;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }

}
