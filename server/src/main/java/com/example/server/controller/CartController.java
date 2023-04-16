package com.example.server.controller;

import com.example.server.dto.CartDto;
import com.example.server.dto.CartProductDto;
import com.example.server.dto.CategoryDto;
import com.example.server.dto.CheckoutDto;
import com.example.server.entity.Cart;
import com.example.server.entity.CartProduct;
import com.example.server.enums.CartStatus;
import com.example.server.service.CartProductService;
import com.example.server.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class CartController {
    private CartProductService cartProductService;
    private CartService cartService;

    public CartController(CartProductService cartProductService, CartService cartService){
        this.cartProductService = cartProductService;
        this.cartService = cartService;
    }

    @GetMapping("/add/{cartId}/{productId}")
    public void addCartProductById(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        Optional<Cart> cart = cartService.find(cartId);
        Optional<CartProduct> cartProduct = cartProductService.findByCartIdAndProductId(cartId,productId);
        if(cartProduct.isPresent()) {
            long cartProductId = cartProduct.get().getCartProductId();
            double salesQuantity = cartProduct.get().getSalesQuantity()+1;
            cartProductService.update(cartProductId, salesQuantity);
        }
        else {
            CartProductDto cartProductDto = new CartProductDto();
            cartProductDto.setCartId(cartId);
            cartProductDto.setProductId(productId);
            cartProductDto.setSalesQuantity(1);
            cartProductService.add(cartProductDto);
        }
    }

    @GetMapping("/createCart")
    public long createCart(){
        return cartService.add();
    }

    @DeleteMapping("/remove/{cartId}/{productId}")
    public void deleteCartProductById(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        cartProductService.remove(cartId, productId);
    }
    @PutMapping ("/checkout")
    public void checkout(@RequestBody CheckoutDto checkoutDto){
        cartService.checkout(checkoutDto);
    }

    @GetMapping("/products/{cartId}")
    public List<CartProductDto> getProductsByCartId(@PathVariable("cartId") long cartId){
        return cartProductService.getCartProductList(cartId);
    }

}
