package com.canteen.adminService.util;

import com.canteen.adminService.dao.CartInfoMapper;
import com.canteen.adminService.dao.CartMapper;
import com.canteen.adminService.dao.FoodMapper;
import com.canteen.common.pojo.*;
import com.canteen.common.pojoVo.CommentVo;
import com.canteen.common.pojoVo.FoodVo;
import com.canteen.common.pojoVo.OrderVo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyUtil {

    @Autowired
    CartInfoMapper cartInfoMapper;

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    CartMapper cartMapper;

    public FoodVo getFoodVo(Food food){
        FoodVo foodVo=new FoodVo();
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

    public CommentVo getCommentVo(Comment comment){
        CommentVo commentVo=new CommentVo();
        commentVo.setCanteenId(comment.getCanteenId());
        commentVo.setCommentContent(comment.getCommentContent());
        commentVo.setCommentId(comment.getCommentId());
        commentVo.setOrderId(comment.getOrderId());
        commentVo.setUserId(comment.getUserId());
        return commentVo;
    }


    public OrderVo getOrderVo(Ord order){
    OrderVo orderVo=new OrderVo();
    orderVo.setAllPrice(order.getAllPrice());
    orderVo.setCreatedTime(order.getCreatedTime());
    orderVo.setOrderState(order.getOrderState());
    orderVo.setUserAddress(order.getUserAddress());
    orderVo.setUserName(order.getUserName());
    orderVo.setUserPhone(order.getUserPhone());
    orderVo.setOrderId(order.getOrderId());
    orderVo.setOrderRemark(order.getOrderRemark());
    orderVo.setOrderTime(order.getOrderTime());
    orderVo.setUserEmail(order.getUserEmail());
    orderVo.setUserId(order.getUserId());
    return orderVo;
    }

    public Map selectOneCart(Cart cart){
        Map map=new HashMap();
        CartInfo cartInfo=new CartInfo();
        cartInfo.setCartId(cart.getCartId());
        CartInfo delObj=new CartInfo();
        delObj.setFoodNum(0);
        cartInfoMapper.delete(delObj);//删除表里所有数量为0的食品
        List<CartInfo> list=cartInfoMapper.select(cartInfo);
        List<FoodVo>foodVoList=new ArrayList<FoodVo>();//购物车里的食品集合
        for(CartInfo cartInfo1:list){
            Food food=new Food();
            food.setFoodId(cartInfo1.getFoodId());
            Food foodResult=foodMapper.selectOne(food);//获取这个食品的单价
            FoodVo foodVo=getFoodVo(foodResult);
            foodVo.setFoodNum(cartInfo1.getFoodNum());
            foodVoList.add(foodVo);
        }
        Cart cartRes=cartMapper.selectOne(cart);
        map.put("foodVoList",foodVoList);
        map.put("cart",cartRes);
        return map;
    }
}
