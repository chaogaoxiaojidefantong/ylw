package com.canteen.adminService.service;

import com.canteen.adminService.dao.CanteenMapper;
import com.canteen.common.pojo.Canteen;
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
public class CanteenService {
    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;


    @Autowired
    CanteenMapper canteenMapper;

    /**
     * 添加食堂
     * @param canteen
     * @return
     */
    public BiliResult addCanteen(Canteen canteen){
        Integer i1=canteenMapper.insert(canteen);
        if(i1==0){
            return  BiliResult.build(201,"插入失败");
        }
        return  BiliResult.oK();
    }

    /**
     * 更新食堂信息
     * @param canteen
     * @return
     */
    public BiliResult updateCanteen(Canteen canteen){
        //Integer i1=canteenMapper.updateCanteen(canteen);
        Integer i1=canteenMapper.updateCanteenTest(canteen);
        if(i1==0){
            return BiliResult.build(201,"更新失败");
        }
        return BiliResult.oK();
    }

    /**
     * 查询食堂列表
     * @param canteen
     * @return
     */
    public BiliResult selectCanteen(Canteen canteen){
        List<Canteen> list=canteenMapper.select(canteen);
        if(list.size()==0){
            return BiliResult.build(201,"查询失败或者没有数据");
        }
        return BiliResult.oK(list);
    }

    public BiliResult deleteCanteen(String ids){
        Integer i1=canteenMapper.deleteCanteen(ids.split(","));
        if(i1==0){
            return BiliResult.build(201,"删除失败");
        }
        return BiliResult.oK();
    }

    public BiliResult selectOneCanteen(Canteen canteen){
        Canteen canteen1=canteenMapper.selectOne(canteen);
        if(canteen1==null){
            return BiliResult.build(201,"没有查询到数据");
        }
        return BiliResult.oK(canteen1);
    }

    public BiliResult uploadCanteenPhoto(MultipartFile file, Canteen canteen){
        File file1=new File(fileDir+"/canteen/"+canteen.getCanteenId());
        if(file1.exists()){
            FileUtil.deleteFileInFolder(file1);
        }
        PicUploadResult picUploadResult= UploadImg.doImgUpload(file,fileDir,fileUrl,"canteen/"+canteen.getCanteenId());
        String  imgUrl=picUploadResult.getUrl();
        if(imgUrl!=null){
            Canteen canteen1=new Canteen();
            canteen1.setCanteenId(canteen.getCanteenId());
            canteen1.setCanteenImage(imgUrl);
            canteenMapper.updateCanteen(canteen1);
            return BiliResult.oK(imgUrl);
        }
        return BiliResult.build(201,"上传失败");
    }

    /**
     * 通过名字模糊查询
     * @param canteenName 用户输入的名字
     * @return
     */
    public BiliResult selectByName(String canteenName){
            List<Canteen>list=canteenMapper.selectByName("%"+canteenName+"%");
            if(list.size()==0){
                return BiliResult.build(201,"没有数据");
            }
            return BiliResult.oK(list);
    }


}
