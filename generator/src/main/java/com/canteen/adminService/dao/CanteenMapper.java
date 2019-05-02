package com.canteen.adminService.dao;

import com.canteen.common.pojo.Canteen;

public interface CanteenMapper {
    int deleteByPrimaryKey(Integer canteenId);

    int insert(Canteen record);

    int insertSelective(Canteen record);

    Canteen selectByPrimaryKey(Integer canteenId);

    int updateByPrimaryKeySelective(Canteen record);

    int updateByPrimaryKey(Canteen record);
}