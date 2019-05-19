package com.canteen.adminService.dao;

import com.canteen.common.pojo.CartInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CartInfoMapper extends Mapper<CartInfo> {
    public Integer foodAddOneNum(CartInfo cartInfo);//某个购物车里的某个食品+1

    public Integer foodReduceOneNum(CartInfo cartInfo);
}
