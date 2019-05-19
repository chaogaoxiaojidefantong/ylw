package com.canteen.adminService.controller;

import com.canteen.adminService.service.FoodService;
import com.canteen.common.pojo.Food;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping("/addFood")
    public BiliResult addFood(Food food){
        return  foodService.addFood(food);
    }

    @RequestMapping("/batchDel")
    public BiliResult batchDel(String foods){
        return  foodService.delFood(foods);
    }

    @RequestMapping("/updateFood")
    public  BiliResult updateFood(Food food){
        return foodService.updatefood(food);
    }

    @RequestMapping("selectOneFood")
    public BiliResult selectOne(Food food){
    return foodService.selectOne(food);
    }

    @RequestMapping("selectMany")
    public BiliResult selectMany(Food food){
        return foodService.selectMany(food);
    }

    @RequestMapping("uploadImg")
    public BiliResult uploadImg(MultipartFile file,Food food){
    return foodService.uploadImg(file,food);
    }

    @RequestMapping("selectByName")
    public BiliResult selectByName(String foodName,Integer canteenId){
        return foodService.selectByName(foodName,canteenId);
    }
}
