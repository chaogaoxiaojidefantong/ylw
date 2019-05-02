package com.canteen.common.pojo;

public class Canteen {
    private Integer canteenId;

    private String canteenLabel;

    private String canteenName;

    private String canteenDes;

    private String canteenImage;

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