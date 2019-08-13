package com.canteen.clientService.service;

import com.canteen.clientService.dao.UserCollectMapper;
import com.canteen.common.pojo.UserCollect;
import com.canteen.common.vo.BiliResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class UserCollectService {

    @Autowired
    UserCollectMapper userCollectMapper;

    @Autowired
    RestTemplate restTemplate;

    public ObjectMapper objectMapper;
    /**
     * 收藏
     * @param userCollect
     * @return
     */
    public BiliResult addOne(UserCollect userCollect){
    Integer i1=userCollectMapper.insert(userCollect);
    if(i1==0){
        return BiliResult.build(201,"收藏失败");
    }
    return BiliResult.oK("收藏成功");
    }

    /**
     * 取消收藏
     * @param userCollect
     * @return
     */
    public  BiliResult deleteOne(UserCollect userCollect){
        Integer i1=userCollectMapper.delete(userCollect);
        if(i1==0){
            return BiliResult.build(201,"取消收藏失败");
        }
        return BiliResult.oK("取消收藏成功");
    }

    /**
     * 查看顾客有没有收藏此店铺，如果已收藏则不返回空
     * @param userCollect
     * @return
     */
    public BiliResult selectOne(UserCollect userCollect){
        UserCollect u1=userCollectMapper.selectOne(userCollect);
        if(u1==null){
           return BiliResult.oK();
        }
        return BiliResult.oK(u1);
    }

    /**
     * 获得某个用户收藏的店铺
     * @return
     */
    public BiliResult getUserCollet(Long userId){
       UserCollect userCollect=new UserCollect();
       userCollect.setUserId(userId);
       List<UserCollect>list=userCollectMapper.select(userCollect);
       List<Map>canteenList=new ArrayList<>();
       for(int i=0;i<list.size();i++) {
           MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap();
           multiValueMap.add("canteenId",list.get(i).getCanteenId()+"");
           BiliResult biliResult=restTemplate.postForObject("http://adminService/Canteen/selectOneCanteen",multiValueMap , BiliResult.class);
           LinkedHashMap mapResult= (LinkedHashMap)biliResult.getData();
            canteenList.add(mapResult);
       }
       return BiliResult.oK(canteenList);
    }
}
