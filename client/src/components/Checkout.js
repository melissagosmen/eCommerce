import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Grid from "@mui/material/Grid";
import {addProductToCart, checkout, createCart} from "../services/CartService";
import {TextField, Button} from "@mui/material";
import { useForm } from "react-hook-form";
import {useNavigate} from "react-router-dom";
import {toast} from "react-hot-toast";

const card =  (cartProduct) =>(
    <React.Fragment>
        <CardContent>
            <Typography variant="h5" component="div">
                {cartProduct.productDto.productName}
            </Typography>
            <Typography sx={{ mb: 1.5 }} color="text.secondary">

            </Typography>
            <Typography variant="body2">
                {cartProduct.productDto.salesPrice} TL
            </Typography>
            <Typography sx={{ mb: 1.5 }} color="text.secondary">
                Quantity: {cartProduct.salesQuantity}
            </Typography>
        </CardContent>
        <CardActions sx={{ justifyContent: "center", marginBottom: 1 }}>
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

export default function Checkout({cartProducts}){
    const { register, handleSubmit } = useForm();
    const navigate = useNavigate();

    function onSubmit(data) {
        data.cartId = localStorage.getItem("cartId");
        checkout(data).then(() => {
            localStorage.removeItem("cartId");
            navigate("/");
            navigate(0);
            toast.success("Thanks for purchase!")
        })
    }

    return (
        <>
            <Typography variant='h2' align={'left'} fontWeight={600}>
                Cart
            </Typography>
            <Grid container spacing={2} sx={{marginTop: 2}}>
                {
                    cartProducts?.map((cartProduct) => {
                        return(
                            <Grid item>
                                <Card sx={{minWidth: 275}} variant="outlined">{card(cartProduct)}</Card>
                            </Grid>
                        )
                    })
                }
            </Grid>

            <Typography variant='h4' align={'left'} fontWeight={600} sx={{marginTop: 5}}>
                Personal Information
            </Typography>

            <form onSubmit={handleSubmit(onSubmit)}>
                <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2, marginTop: 2, width: '75ch' }}>
                    <TextField id="outlined-basic" label="Name" variant="outlined" {...register("customerName")} required />
                    <TextField id="outlined-basic" label="Card Number" type='number' variant="outlined" {...register("cardNumber")} required />
                    <Button type="submit" variant="contained" sx={{background: '#4d72eb'}}>Checkout</Button>
                </Box>
            </form>
        </>

    );
}