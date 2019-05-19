package com.canteen.adminService.controller;

import com.canteen.adminService.service.CartService;
import com.canteen.common.pojo.Cart;
import com.canteen.common.pojo.CartInfo;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cart/")
public class CartController {

    @Autowired
    CartService cartService;

//    @RequestMapping("cartAddOneFood")
//    public BiliResult cartAddOneFood(Cart cart, CartInfo cartInfo){
//    return  cartService.cartAddOneFood(cart,cartInfo);
//    }

    @RequestMapping("foodAddNum")
    public BiliResult foodAddNum(Cart cart,CartInfo cartInfo)
    {
        return cartService.foodAddNum(cart,cartInfo);
    }

    @RequestMapping("foodReduceOneNum")
    public BiliResult foodReduceOneNum(Cart cart,CartInfo cartInfo){
        return cartService.foodReduceOneNum(cart,cartInfo);
    }

    @RequestMapping("selectOne")
    public BiliResult selectOne(Cart cart){
        return cartService.selectOne(cart);
    }

    @RequestMapping("clearCart")
    public BiliResult clearCart(Cart cart){
        return cartService.clearCart(cart);
    }

}
