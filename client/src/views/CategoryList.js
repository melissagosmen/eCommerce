import * as React from 'react';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';
import IconButton from "@mui/material/IconButton";
import Badge from "@mui/material/Badge";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import MoreIcon from "@mui/icons-material/MoreVert";
import Products from "../components/Products";
import Grid from '@mui/material/Grid';
import {useEffect, useState} from "react";
import {getCategories} from "../services/CategoryService";
import {Route, Routes, useLocation, useNavigate} from "react-router-dom";
import SellIcon from '@mui/icons-material/Sell';
import {getProducts} from "../services/ProductsService";
import Checkout from "../components/Checkout";
import {getCartProducts} from "../services/CartService";


const drawerWidth = 240;

export default function CategoryList() {

    const navigate = useNavigate()
    const location = useLocation()
    const [categories, setCategories] = useState([])
    const [selectedCategoryId, setSelectedCategoryId] = useState(0)
    const [products, setProducts] = useState([]);
    const [cartProducts, setCartProducts] = useState([]);


    useEffect(() => {
        getCategories().then((res) =>
        {
            setCategories(res)
        });
    },[])

    useEffect(() => {
        getProducts(selectedCategoryId).then((res) => {
            setProducts(res)
        })
    },[selectedCategoryId]);

    useEffect(() => {
        const cartId = localStorage.getItem('cartId');
        if(cartId){
            getCartProducts(cartId).then((res) => {
                setCartProducts(res)
            })
        }
    },[localStorage.getItem('cartId')])


    return (
        <Box sx={{ display: 'flex' }}>
            <CssBaseline />
            <AppBar
                position="fixed"
                sx={{ width: `calc(100% - ${drawerWidth}px)`, ml: `${drawerWidth}px`, background: '#4d72eb' }}
            >
                <Toolbar>
                    <Typography
                        variant="h6"
                        noWrap
                        component="div"
                        sx={{ display: { xs: 'none', sm: 'block' } }}
                    >
                        E - Commerce
                    </Typography>
                    <Box sx={{ flexGrow: 1 }} />
                    <Box sx={{ display: { xs: 'none', md: 'flex' } }}>
                        <IconButton onClick={() => navigate('/checkout')} size="large" color="inherit">
                            <AddShoppingCartIcon/>
                        </IconButton>
                    </Box>
                </Toolbar>
            </AppBar>
            <Drawer
                sx={{
                    width: drawerWidth,
                    flexShrink: 0,
                    '& .MuiDrawer-paper': {
                        width: drawerWidth,
                        boxSizing: 'border-box',
                    },
                }}
                variant="permanent"
                anchor="left"
            >
                <Toolbar />
                <Divider />
                <List>
                    {categories.map((category, id) => (
                        <ListItem onClick={() => setSelectedCategoryId(category.categoryId)} key={category.categoryName} disablePadding>
                            <ListItemButton onClick={() => navigate('/')} component="a" >
                                <ListItemIcon sx={{ fontSize: 20 }}><SellIcon/></ListItemIcon>
                                <ListItemText primary={category.categoryName} />
                            </ListItemButton>
                        </ListItem>
                    ))}
                </List>
            </Drawer>
            <Box
                component="main"
                sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}
            >
                <Toolbar />
                {
                    location.pathname === '/' ? <Products products={products}/> : <Checkout cartProducts={cartProducts}/>
                }
            </Box>
        </Box>
    );
}