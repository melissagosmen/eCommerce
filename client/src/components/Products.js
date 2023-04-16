import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import {useEffect, useState} from "react";
import Grid from "@mui/material/Grid";
import {addProductToCart, createCart} from "../services/CartService";
import {toast} from "react-hot-toast";

const card =  (product) =>(
    <React.Fragment>
        <CardContent>
            <Typography variant="h5" component="div">
                {product.productName}
            </Typography>
            <Typography sx={{ mb: 1.5 }} color="text.secondary">

            </Typography>
            <Typography variant="body2">
                {product.salesPrice} TL
            </Typography>
        </CardContent>
        <CardActions sx={{ justifyContent: "center", marginBottom: 1 }}>
                <Button onClick={() => {
                    addProduct(product.productId);
                    toast.success('Product successfully added to Cart')
                }} size="small" variant='contained' sx={{ justifyContent: "center",background: '#4d72eb'}}> Add to Cart </Button>
        </CardActions>
    </React.Fragment>
);

const addProduct = (productId) => {
    if (localStorage.getItem('cartId') == null) {
        createCart().then((res => {
            localStorage.setItem("cartId", res);
        }))
    }
    const cartId = localStorage.getItem('cartId');
    console.log(cartId);
    addProductToCart(cartId, productId).then((res) => console.log("eklendi"));
}

export default function Products({products}) {
    return (

        <Grid container spacing={2}>
            {
                products?.map((product) => {
                    return(
                        <Grid item>
                            <Card sx={{minWidth: 275}} variant="outlined">{card(product)}</Card>
                        </Grid>
                    )
                })
            }
        </Grid>
    );
}