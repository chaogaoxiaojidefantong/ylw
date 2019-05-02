package com.canteen.adminService.dao;

import com.canteen.common.pojo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FoodMapper extends Mapper<Food> {
public Integer batchDel(@Param("foods") String []foods);
public Integer updateFood(Food food);
}
