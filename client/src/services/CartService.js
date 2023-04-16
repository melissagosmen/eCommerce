import axios from "axios";

export const createCart = async () => {
    return await fetch("http://localhost:8080/cart/createCart").then(res => res.json());
}

export const addProductToCart = async (cartId, productId) => {
    return await fetch("http://localhost:8080/cart/add/" + cartId + '/' + productId);
}

export const getCartProducts = async (cartId) => {
    return await fetch("http://localhost:8080/cart/products/" + cartId ).then(res => res.json());
}

export const checkout = async (data) => {
    return await axios.put(`http://localhost:8080/cart/checkout`, data);
}
