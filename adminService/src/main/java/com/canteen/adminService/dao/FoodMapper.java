package com.canteen.adminService.dao;

import com.canteen.common.pojo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface FoodMapper extends Mapper<Food> {
public Integer batchDel(@Param("foods") String []foods);
public Integer updateFood(Food food);
public List<Food>selectByName(@Param("foodName")String foodName,@Param("canteenId")Integer canteenId);
}
