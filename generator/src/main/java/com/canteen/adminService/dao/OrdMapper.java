package com.canteen.adminService.dao;

import com.canteen.common.pojo.Ord;

public interface OrdMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Ord record);

    int insertSelective(Ord record);

    Ord selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Ord record);

    int updateByPrimaryKey(Ord record);
}