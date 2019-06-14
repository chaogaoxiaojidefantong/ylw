package com.canteen.adminService.service;
import com.canteen.adminService.dao.*;
import com.canteen.adminService.util.EasyUtil;
import com.canteen.common.pojo.*;
import com.canteen.common.pojoVo.FoodVo;
import com.canteen.common.pojoVo.OrderVo;
import com.canteen.common.util.TimeUtil;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrdMapper ordMapper;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CartService cartService;

    @Autowired
    EasyUtil easyUtil;

    //添加订单
    public BiliResult addOne(Ord order, Long addressId) {
        Address address = new Address();
        address.setAddressId(addressId);
        Address addressResult = addressMapper.selectOne(address);
        order.setCreatedTime(TimeUtil.nowtime());
        order.setUserAddress(addressResult.getUserAddress());
        order.setUserPhone(addressResult.getUserPhone());
        order.setUserName(addressResult.getUserName());
        Long userId = order.getUserId();
        Cart cart = new Cart();
        cart.setUserId(userId);
        Map map = cartService.selectOneCart(cart);//获得这个人购物车的信息
        Cart cart1 = (Cart) map.get("cart");
        order.setAllPrice(cart1.getAllPrice());
        order.setOrderState(0);
        ordMapper.insert(order);
        order.setCreatedTime(null);
        Ord orderResult = ordMapper.selectOne(order);
        List<FoodVo> l1 = (ArrayList<FoodVo>) map.get("foodVoList");
        for (FoodVo foodVo : l1) {
            Integer foodNum = foodVo.getFoodNum();
            Long foodId = foodVo.getFoodId();
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(orderResult.getOrderId());
            orderInfo.setFoodId(foodId);
            orderInfo.setFoodNum(foodNum);
            orderInfoMapper.insert(orderInfo);
        }
        cartService.clearCart(cart);//最后需要清空购物车
        easyUtil.updateFoodSale();//更新所有商品的销量
        return BiliResult.oK();
    }

    //查询某人的订单
    public BiliResult selectUserOrder(Ord order) {
        List<Ord> list = ordMapper.select(order);
        List<OrderVo> voList = new ArrayList<>();
        for (Ord orderone : list) {
            OrderVo orderVo = getOrderVoGo(orderone);
            voList.add(orderVo);
        }
        return BiliResult.oK(voList);
    }

    /**
     * 修改订单状态
     *
     * @param order
     * @return
     */
    public BiliResult updateState(Ord order) {
        Integer i1 = ordMapper.updateState(order);
        if (i1 == 0) {
            return BiliResult.build(201, "修改失败");
        }
        return BiliResult.oK();
    }


    //通过订单号获得订单的所有信息，包括此订单中包括哪些食品
    public OrderVo getOrderVoGo(Ord order) {
       easyUtil = new EasyUtil();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(order.getOrderId());
        List<OrderInfo> list = orderInfoMapper.select(orderInfo);
        List<FoodVo> foodVoList = new ArrayList<>();
        for (OrderInfo orderInfo1 : list) {
            Food food = new Food();
            food.setFoodId(orderInfo1.getFoodId());
            Food foodResult = foodMapper.selectOne(food);
            FoodVo foodVo = easyUtil.getFoodVo(foodResult);
            foodVo.setFoodNum(orderInfo1.getFoodNum());
            foodVoList.add(foodVo);
        }
        OrderVo orderVo = easyUtil.getOrderVo(order);
        orderVo.setFoodAndNum(foodVoList);
        return orderVo;
    }


}
