package com.canteen.common.pojoVo;

import com.canteen.common.pojo.Food;

import java.util.Date;

public class FoodVo extends Food {
    private Integer foodNum;

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public FoodVo(Food food,Integer num){
        setFoodNum(num);
        setFoodRateNumber(food.getFoodRateNumber());
        setFoodRate(food.getFoodRate());
        setFoodName(food.getFoodName());
        setCreatedTime(food.getCreatedTime());
        setFoodPrice(food.getFoodPrice());
        setFoodDescribe(food.getFoodDescribe());
        setCanteenId(food.getCanteenId());
        setFoodImage(food.getFoodImage());
        setFoodId(food.getFoodId());
    }
    public FoodVo(){

    }
}