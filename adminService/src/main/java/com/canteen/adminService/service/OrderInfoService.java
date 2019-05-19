package com.canteen.adminService.service;

import com.canteen.adminService.dao.OrderInfoMapper;
import com.canteen.common.pojo.OrderInfo;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    /**
     * 添加订单额外信息
     * @param orderInfo
     * @return
     */
    public BiliResult addOne(OrderInfo orderInfo){
    Integer i1=orderInfoMapper.insert(orderInfo);
    if(i1==0){
        return BiliResult.build(201,"添加失败");
    }
    return BiliResult.oK();
    }

}
