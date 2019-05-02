package com.canteen.adminService.dao;

import com.canteen.common.pojo.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(Long foodId);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Long foodId);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}