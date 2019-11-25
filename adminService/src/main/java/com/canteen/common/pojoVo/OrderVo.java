package com.canteen.common.pojoVo;

import com.canteen.common.pojo.Ord;

import java.util.List;

public class OrderVo extends Ord {
    private List<FoodVo>foodAndNum;

    public List<FoodVo> getFoodAndNum() {
        return foodAndNum;
    }

    public void setFoodAndNum(List<FoodVo> foodAndNum) {
        this.foodAndNum = foodAndNum;
    }
}
