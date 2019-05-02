package com.canteen.common.pojo;

import java.util.Date;

public class Food {
    private Long foodId;

    private String foodDescribe;

    private Integer foodPrice;

    private String foodImage;

    private Integer canteenId;

    private String foodName;
    //评分
    private Double foodRate;

    //打分次数
    private Long foodRateNumber;

    private Date createdTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Double getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(Double foodRate) {
        this.foodRate = foodRate;
    }


    public Long getFoodRateNumber() {
        return foodRateNumber;
    }

    public void setFoodRateNumber(Long foodRateNumber) {
        this.foodRateNumber = foodRateNumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodDescribe() {
        return foodDescribe;
    }

    public void setFoodDescribe(String foodDescribe) {
        this.foodDescribe = foodDescribe == null ? null : foodDescribe.trim();
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage == null ? null : foodImage.trim();
    }

    public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }
}