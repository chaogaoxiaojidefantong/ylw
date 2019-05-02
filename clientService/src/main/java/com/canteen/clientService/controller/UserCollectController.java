package com.canteen.clientService.controller;
import com.canteen.clientService.service.UserCollectService;
import com.canteen.common.pojo.UserCollect;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserCollect")
public class UserCollectController {
    @Autowired
    UserCollectService userCollectService;

    @RequestMapping("/addOne")
    public BiliResult addOne(UserCollect userCollect){
        return  userCollectService.addOne(userCollect);
    }

    @RequestMapping("/deleteOne")
    public BiliResult deleteOne(UserCollect userCollect){
        return userCollectService.deleteOne(userCollect);
    }

    @RequestMapping("/selectOne")
    public BiliResult selectOne(UserCollect userCollect){
        return userCollectService.selectOne(userCollect);
    }


}
