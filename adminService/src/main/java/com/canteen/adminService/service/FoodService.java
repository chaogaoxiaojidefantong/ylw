package com.canteen.adminService.service;

import com.canteen.adminService.dao.FoodMapper;
import com.canteen.common.pojo.Food;
import com.canteen.common.util.FileUtil;
import com.canteen.common.util.UploadImg;
import com.canteen.common.vo.BiliResult;
import com.canteen.common.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class FoodService {

    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;

    @Autowired
    FoodMapper foodMapper;

    public BiliResult addFood(Food food){
        food.setFoodSale(0);
    Integer i1=foodMapper.insert(food);
    if(i1==0){
        return  BiliResult.build(201,"添加食品失败");
    }
    return BiliResult.oK("添加成功");
    }

    public BiliResult delFood(String foods){
        Integer i1=foodMapper.batchDel(foods.split(","));
        if(i1==0){
            return  BiliResult.build(201,"删除失败");
        }
        return BiliResult.oK("删除成功");
    }

    public BiliResult updatefood(Food food){
    Integer i1=foodMapper.updateFood(food);
        if(i1==0){
            return  BiliResult.build(201,"修改失败");
        }
        return BiliResult.oK("修改成功");
    }

    public BiliResult selectOne(Food food){
        Food food1=foodMapper.selectOne(food);
        if(food1==null){
            return  BiliResult.build(201,"没有数据");
        }
        return BiliResult.oK(food1);
    }

    public BiliResult selectMany(Food food){
        List<Food> list=foodMapper.select(food);
        if(list.size()==0){
            return BiliResult.build(201,"没有数据");
        }
        return BiliResult.oK(list);
    }

    public BiliResult uploadImg(MultipartFile file,Food food){
        File mkdirFile=new File(fileDir+"/canteen/"+food.getCanteenId()+"/"+food.getFoodId());
        if(!mkdirFile.exists()){
            mkdirFile.mkdir();
        }
        FileUtil.deleteFile(mkdirFile);
       PicUploadResult picUploadResult= UploadImg.doImgUpload(file,fileDir,fileUrl,"canteen/"+food.getCanteenId()+"/"+food.getFoodId());
       if(picUploadResult.getUrl()!=null){
           Food food1=new Food();
           food1.setFoodId(food.getFoodId());
           food1.setFoodImage(picUploadResult.getUrl());
           foodMapper.updateFood(food1);
           return BiliResult.oK(picUploadResult.getUrl());
       }
       return BiliResult.build(201,"上传图片失败");
    }

    /**
     * 通过食品名模糊查询食品
     * @param foodName
     * @return
     */
    public BiliResult selectByName(String foodName,Integer canteenId){
        List<Food>list=foodMapper.selectByName("%"+foodName+"%",canteenId);
        return BiliResult.oK(list);
    }

    /**
     * 通过销量查询某食堂的所有食品
     * @param canteenId
     * @return
     */
    public  BiliResult selectManyByDesc(Integer canteenId){
        List<Food>list=foodMapper.selectManyByDesc(canteenId);
        return BiliResult.oK(list);
    }
}
