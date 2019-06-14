package com.canteen.adminService.dao;

import com.canteen.common.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderInfoMapper extends Mapper<OrderInfo> {
    public List<Long> getfoodIds();//获取有销量的食品的id集合
    public  Integer getfoodSale(@Param("foodId") Long foodId);

}
