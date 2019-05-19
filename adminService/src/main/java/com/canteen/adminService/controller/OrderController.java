package com.canteen.adminService.controller;

import com.canteen.adminService.service.OrderService;
import com.canteen.common.pojo.Ord;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("addOne")
    public BiliResult addOne(Ord order, Long addressId){
        return orderService.addOne(order,addressId);
    }

    @RequestMapping("selectUserOrder")
    public BiliResult selectUserOrder(Ord order){
    return orderService.selectUserOrder(order);
    }

    @RequestMapping("updateState")
    public BiliResult updateState(Ord order){
        return orderService.updateState(order);
    }


}
