package com.canteen.adminService.dao;

import com.canteen.common.pojo.CartInfo;

public interface CartInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartInfo record);

    int insertSelective(CartInfo record);

    CartInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartInfo record);

    int updateByPrimaryKey(CartInfo record);
}