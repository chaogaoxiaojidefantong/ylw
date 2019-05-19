package com.canteen.adminService.dao;

import com.canteen.common.pojo.Ord;
import com.canteen.common.pojo.OrderInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrdMapper extends Mapper<Ord> {
    public Integer updateState(Ord order);
}
