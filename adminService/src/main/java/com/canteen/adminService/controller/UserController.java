package com.canteen.adminService.controller;

import com.canteen.adminService.service.UserService;
import com.canteen.common.pojo.User;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public BiliResult login(User user){
        return userService.login(user);
    }
    @RequestMapping("/regist")
    public BiliResult regist(User user){
        return userService.regist(user);
    }

    @RequestMapping("/batchDel")
    public  BiliResult batchDel(String users){
        return userService.batchDel(users);
    }

    @RequestMapping("/updateUser")
    public  BiliResult updateUser(User user){
        return userService.updateUser(user);
    }

    @RequestMapping("/loginByToken")
    public BiliResult loginByToken(String token){
        return userService.loginByToken(token);
    }

    @RequestMapping("/userList")
    public BiliResult userList(User user){
        return userService.userList(user);
    }

    @RequestMapping("/selectOne")
    public  BiliResult selectOne(User user){
        return userService.selectOne(user);
    }

    @RequestMapping("/logout")
    public BiliResult logout(String token){
        return userService.logout(token);
    }

    /**
     * 发送邮箱验证码
     * @param user
     * @return
     */
    @RequestMapping("emailCheck")
    public BiliResult emailCheck(User user){
        return userService.emailGoCheck(user);
    }

    @RequestMapping("loginBycode")
    public BiliResult loginBycode(User user){
        return userService.loginBycode(user);
    }

    @RequestMapping("updateUserByCode")
    public BiliResult updateUserByCode(User user){
        return userService.updateUserByCode(user);
    }

    @RequestMapping("loginByWeChat")
    public BiliResult loginByWeChat(User user){
        return userService.loginByWeChat(user);
    }

    @RequestMapping("registEmailJudge")
    public BiliResult registEmailJudge(String email){
        return userService.registEmailJudge(email);
    }
}
