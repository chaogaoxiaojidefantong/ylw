package com.canteen.common.pojo;

public class Canteen {
    private Integer canteenId;

    private String canteenLabel;

    private String canteenName;

    private String canteenDes;

    //食堂图片的地址
    private String canteenImage;
    //打分人数
    private  Integer canteenMarkNumber;

    //评分
    private  Double canteenMark;

    //销量
    private Long sales;

    public Double getCanteenMark() {
        return canteenMark;
    }

    public void setCanteenMark(Double canteenMark) {
        this.canteenMark = canteenMark;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Integer getCanteenMarkNumber() {
        return canteenMarkNumber;
    }

    public void setCanteenMarkNumber(Integer canteenMarkNumber) {
        this.canteenMarkNumber = canteenMarkNumber;
    }

    public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenLabel() {
        return canteenLabel;
    }

    public void setCanteenLabel(String canteenLabel) {
        this.canteenLabel = canteenLabel == null ? null : canteenLabel.trim();
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName == null ? null : canteenName.trim();
    }

    public String getCanteenDes() {
        return canteenDes;
    }

    public void setCanteenDes(String canteenDes) {
        this.canteenDes = canteenDes == null ? null : canteenDes.trim();
    }

    public String getCanteenImage() {
        return canteenImage;
    }

    public void setCanteenImage(String canteenImage) {
        this.canteenImage = canteenImage == null ? null : canteenImage.trim();
    }
}