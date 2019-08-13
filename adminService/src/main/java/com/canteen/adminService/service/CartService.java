package com.canteen.adminService.service;

import com.canteen.adminService.dao.CartInfoMapper;
import com.canteen.adminService.dao.CartMapper;
import com.canteen.adminService.dao.FoodMapper;
import com.canteen.common.pojo.Cart;
import com.canteen.common.pojo.CartInfo;
import com.canteen.common.pojo.Food;
import com.canteen.common.pojoVo.FoodVo;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CartInfoMapper cartInfoMapper;

    @Autowired
    FoodMapper foodMapper;

//    /**
//     * 往购物车中添加某件商品，此商品还没添加过
//     * @param cart
//     * @return
//     */
//    public BiliResult cartAddOneFood(Cart cart, CartInfo cartInfo){
//    Integer i1=cartInfoMapper.insert(cartInfo);
//    if(i1==0){
//        return BiliResult.build(201,"添加食品成功");
//    }
//        Map map=selectOneCart(cart);
//    return BiliResult.oK(map);
//    }

    /**
     * 商品数量+1
     *
     * @param cart
     * @param cartInfo
     * @return
     */
    public BiliResult foodAddNum(Cart cart, CartInfo cartInfo) {
        CartInfo cartInfo1 = cartInfoMapper.selectOne(cartInfo);
        if (cartInfo1 == null) {//如果这件商品没在购物车里过，则添加到购物车里，并且数量为1
            cartInfo.setFoodNum(1);
            cartInfoMapper.insert(cartInfo);
        } else {
            cartInfoMapper.foodAddOneNum(cartInfo);
        }
        updateAllPrice(cart);
        Map map = selectOneCart(cart);
        return BiliResult.oK(map);
    }

    /**
     * 某样商品已经添加过，只是数量-1
     *
     * @param cart
     * @param cartInfo
     * @return
     */
    public BiliResult foodReduceOneNum(Cart cart, CartInfo cartInfo) {
        cartInfoMapper.foodReduceOneNum(cartInfo);
        updateAllPrice(cart);
        Map map = selectOneCart(cart);
        return BiliResult.oK(map);
    }

    /**
     * 查询某人的购物车与他购物车里的食品
     *
     * @param cart
     * @return
     */
    public BiliResult selectOne(Cart cart) {
        Map map = selectOneCart(cart);
        return BiliResult.oK(map);
    }

    /**
     * 修改购物车的金额
     *
     * @param cart
     * @return
     */
    public Integer updateAllPrice(Cart cart) {
        CartInfo cartInfo = new CartInfo();
        cartInfo.setCartId(cart.getCartId());
        List<CartInfo> list = cartInfoMapper.select(cartInfo);
        Integer allPrice = 0;
        for (CartInfo cartInfo1 : list) {
            Food food = new Food();
            food.setFoodId(cartInfo1.getFoodId());
            Food foodResult = foodMapper.selectOne(food);
            Integer price = foodResult.getFoodPrice();
            allPrice = cartInfo1.getFoodNum() * price + allPrice;
        }
        cart.setAllPrice(allPrice);
        return cartMapper.updateAllPrice(cart);//修改总金额
    }


    /**
     * 返回此购物车与购物车里的商品
     *
     * @return
     */
    public Map selectOneCart(Cart cart) {
        Map map = new HashMap();
        Cart cartObj=cartMapper.selectOne(cart);
        CartInfo cartInfo = new CartInfo();
        cartInfo.setCartId(cartObj.getCartId());
        CartInfo delObj = new CartInfo();
        delObj.setFoodNum(0);
        cartInfoMapper.delete(delObj);//删除表里所有数量为0的食品
        List<CartInfo> list = cartInfoMapper.select(cartInfo);
        List<FoodVo> foodVoList = new ArrayList<FoodVo>();//购物车里的食品集合
        for (CartInfo cartInfo1 : list) {
            Food food = new Food();
            food.setFoodId(cartInfo1.getFoodId());
            Food foodResult = foodMapper.selectOne(food);//获取这个食品的单价
            FoodVo foodVo = getFoodVo(foodResult);
            foodVo.setFoodNum(cartInfo1.getFoodNum());
            foodVoList.add(foodVo);
        }
        Cart cartRes = cartMapper.selectOne(cart);
        map.put("foodVoList", foodVoList);
        map.put("cart", cartRes);
        return map;
    }

    public FoodVo getFoodVo(Food food) {
        FoodVo foodVo = new FoodVo();
        foodVo.setFoodId(food.getFoodId());
        foodVo.setFoodImage(food.getFoodImage());
        foodVo.setCanteenId(food.getCanteenId());
        foodVo.setFoodDescribe(food.getFoodDescribe());
        foodVo.setFoodPrice(food.getFoodPrice());
        foodVo.setCreatedTime(food.getCreatedTime());
        foodVo.setFoodName(food.getFoodName());
        foodVo.setFoodRate(food.getFoodRate());
        foodVo.setFoodRateNumber(food.getFoodRateNumber());
        return foodVo;
    }

    /**
     * 清空购物车
     *
     * @param cart
     * @return
     */
    public BiliResult clearCart(Cart cart) {
        Integer cartId = cart.getCartId();
        CartInfo cartInfo = new CartInfo();
        cartInfo.setCartId(cartId);
        cartInfoMapper.delete(cartInfo);
        cart.setAllPrice(0);
        cartMapper.updateAllPrice(cart);
        return BiliResult.oK();
    }
}
