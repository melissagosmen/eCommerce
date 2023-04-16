package com.example.server.service.impl;

import com.example.server.dto.CartProductDto;
import com.example.server.dto.ProductDto;
import com.example.server.entity.Cart;
import com.example.server.entity.CartProduct;
import com.example.server.entity.Product;
import com.example.server.enums.CartStatus;
import com.example.server.repository.CartProductRepository;
import com.example.server.repository.CartRepository;
import com.example.server.repository.ProductRepository;
import com.example.server.service.CartProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.server.dto.ProductDto.toDto;

@Service

public class CartProductServiceImpl implements CartProductService {
    private CartProductRepository cartProductRepository;
    private ProductRepository productRepository;
    public CartProductServiceImpl(CartProductRepository cartProductRepository, ProductRepository productRepository){
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void add(CartProductDto cartProductDto) {
        cartProductRepository.save(cartProductDto.toEntity());
    }

    @Override
    @Transactional
    public void remove(long cartId, long productId) {
        cartProductRepository.deleteByCartIdAndProductId(cartId, productId);
    }

    @Override
    public Optional<CartProduct> findByCartIdAndProductId(long cartId, long productId) {
        return cartProductRepository.findByCartIdAndProductId(cartId,productId);
    }

    @Override
    public void update(long cartProductId, double salesQuantity) {
        cartProductRepository.updateSalesQuantity(cartProductId,salesQuantity);
    }

    @Override
    public List<CartProductDto> getCartProductList(long cartId) {
        List<CartProductDto> cartProductDtos = new ArrayList<>();
        for(CartProduct cartProduct : cartProductRepository.getCartProductsByCartId(cartId)){
            Product product = productRepository.findById(cartProduct.getProductId()).get();
            CartProductDto cartProductDto = CartProductDto.toDto(cartProduct);
            cartProductDto.setProductDto(ProductDto.toDto(product));
            cartProductDtos.add(cartProductDto);
        }
        return cartProductDtos;
    }

}
