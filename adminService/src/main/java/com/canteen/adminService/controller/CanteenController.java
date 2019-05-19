package com.canteen.adminService.controller;

import com.canteen.adminService.service.CanteenService;
import com.canteen.common.pojo.Canteen;
import com.canteen.common.util.UploadImg;
import com.canteen.common.vo.BiliResult;
import com.canteen.common.vo.PicUploadResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Canteen")
public class CanteenController {

    @Autowired
    CanteenService canteenService;

    @RequestMapping("/addCanteen")
    public BiliResult addCanteen(Canteen canteen) {
        return canteenService.addCanteen(canteen);
    }

    @RequestMapping("/updateCanteen")
    public BiliResult updateCanteen(Canteen canteen) {
        return canteenService.updateCanteen(canteen);
    }

    @RequestMapping("/selectCanteen")
    public BiliResult selectCanteen(Canteen canteen){
       return  canteenService.selectCanteen(canteen);
    }

    @RequestMapping("/deleteCanteen")
    public BiliResult deleteCanteen(String canteens) {
        return  canteenService.deleteCanteen(canteens);
    }

    @RequestMapping("/selectOneCanteen")
    public BiliResult selectOneCanteen(Canteen canteen){
        return canteenService.selectOneCanteen(canteen);
    }

    @RequestMapping("/uploadCanteenImg")
    public BiliResult uploadCanteenPhoto(MultipartFile file,Canteen canteen){
        return  canteenService.uploadCanteenPhoto(file,canteen);
    }
    /**
     * 通过名字模糊查询
     * @param canteenName
     * @return
     */
    @RequestMapping("selectByName")
    public BiliResult selectByName(String canteenName){
    return canteenService.selectByName(canteenName);
    }
}
