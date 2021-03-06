package com.canteen.adminService.service;

import com.canteen.adminService.dao.CartMapper;
import com.canteen.adminService.dao.UserMapper;
import com.canteen.common.pojo.Cart;
import com.canteen.common.pojo.User;
import com.canteen.common.util.EmailUtil;
import com.canteen.common.util.JsonUtil;
import com.canteen.common.util.RandomUtil;
import com.canteen.common.vo.BiliResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    public String emailFrom = "759646095@qq.com";
    public String emailAuthorization = "boxpurjjugqmbfbc";

    @Autowired
    UserMapper userMapper;

    @Autowired
    CartMapper cartMapper;

    public JsonUtil<User> jsonUtil = new JsonUtil();

    Jedis jedis = new Jedis();

    public BiliResult login(User user) {
        String userPwd = user.getUserPwd();
        user.setUserPwd(DigestUtils.md5Hex(userPwd));
        User user1 = userMapper.selectOne(user);
        if (user1 == null) {
            return BiliResult.build(201, "登录有误");
        } else {
            Map map = handleToken(user1);
            return BiliResult.oK(map);
        }
    }

    public BiliResult regist(User user) {
        User userResult=null;
        user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()));
        Integer i1 = userMapper.insert(user);
        if (i1 == 0) {
            return BiliResult.build(201, "注册失败");
        }
        if (user.getUserStatus() == 3) {//如果是顾客注册则添加购物车
            User userOne = new User();
            userOne.setUserEmail(user.getUserEmail());
            userResult = userMapper.selectOne(userOne);
            Cart cart = new Cart();
            cart.setAllPrice(0);
            cart.setUserId(userResult.getUserId());
            cartMapper.insert(cart);
            Cart cartResult = cartMapper.selectOne(cart);
            userResult.setCartId(cartResult.getCartId());
            userMapper.updateUser(userResult);
        }
        return BiliResult.oK(userResult);
    }

    /**
     * 更改用户信息
     */
    public BiliResult updateUser(User user) {
        String userPwd = DigestUtils.md5Hex(user.getUserPwd());
        user.setUserPwd(userPwd);
        Integer i1 = userMapper.updateUser(user);
        if (i1 == 0) {
            return BiliResult.build(201, "更新失败");
        }
        User user1 = new User();
        user1.setUserId(user.getUserId());
        User userResult = userMapper.selectOne(user1);
        Map map = handleToken(userResult);
        return BiliResult.oK(map);
    }

    /**
     * 批量删除用户
     *
     * @param users
     * @return
     */
    public BiliResult batchDel(String users) {
        Integer i1 = userMapper.batchDel(users.split(","));
        if (i1 == 0) {
            return BiliResult.build(201, "删除失败");
        }
        return BiliResult.oK();
    }

    /**
     * 发送邮箱验证码
     *
     * @param user
     * @return
     */
    public BiliResult emailGoCheck(User user) {
        String userEmail = user.getUserEmail();
        //String verifyCode=RandomUtil.randomVerifyCode(6);
        EmailUtil emailUtil = new EmailUtil();
        String verifyCode = emailUtil.emailCheck(userEmail);
        user.setVerifyCode(verifyCode);
        Integer i1 = userMapper.updateUser(user);
        if (i1 == 0) {
            return BiliResult.build(201, "发送验证码失败");
        }
        return BiliResult.oK();
    }

    /**
     * 通过邮箱验证码登录
     *
     * @param user
     * @return
     */
    public BiliResult loginBycode(User user) {
        User user1 = userMapper.selectOne(user);
        if (user1 == null) {
            return BiliResult.build(201, "登录有误");
        } else {
            Map map = handleToken(user1);
            return BiliResult.oK(map);
        }
    }

    /**
     * 微信登录
     * @param user
     * @return
     */
    public BiliResult loginByWeChat(User user){
        User user1=null;
        User userSelect=new User();
        userSelect.setUserEmail(user.getUserEmail());
       user1= userMapper.selectOne(userSelect);
       if(user1==null){
           userMapper.insert(user);//如果数据库没有这个用户，则需要先注册进去
           User userResult=userMapper.selectOne(user);
           Cart cartResult=insertCart(userResult.getUserId());
           userResult.setCartId(cartResult.getCartId());
           userMapper.updateUser(userResult);
          user1=userMapper.selectOne(user);
       }
       Map map=handleToken(user1);
       return BiliResult.oK(map);
    }

    /**
     * 给新注册的账号添加购物车,并返回添加后的购物车
     * @param userId
     */
    public Cart  insertCart(Long userId){
        Cart cart=new Cart();
        cart.setUserId(userId);
        cart.setAllPrice(0);
        cartMapper.insert(cart);
        Cart cartResult=cartMapper.selectOne(cart);
        return cartResult;
    }




    public BiliResult userList(User user) {
        return BiliResult.oK(userMapper.select(user));
    }

    public BiliResult selectOne(User user) {
        return BiliResult.oK(userMapper.selectOne(user));
    }

    public Map handleToken(User user) {
        String token = user.getUserEmail() + UUID.randomUUID();//token的保留形式为用户邮箱+随机数
        String JsonUser2 = jsonUtil.writeObjToJsonString(user);//转为JSON格式，存储到redis服务器里
        //jedisCluster.setex(token,60*60*24,JsonUser2);//保存时间为一天
        jedis.set(token, JsonUser2);
        jedis.expire(token, 60 * 60 * 24);
        Map map = new HashMap();
        map.put("user", user);
        map.put("token", token);
        return map;
    }

    public BiliResult loginByToken(String token) {
        String userJSON = jedis.get(token);
        User user = jsonUtil.writeJsonStringToObj(userJSON, User.class);
        Map map = handleToken(user);
        return BiliResult.oK(map);
    }

    public BiliResult logout(String token) {
        jedis.del(token);
        return BiliResult.oK();
    }

    //修改通过邮箱验证码修改密码
    public BiliResult updateUserByCode(User user) {
        String userPwd = DigestUtils.md5Hex(user.getUserPwd());
        user.setUserPwd(userPwd);
        Integer i1 = userMapper.updateUserByCode(user);
        if (i1 == 0) {
            return BiliResult.build(201, "修改失败");
        }
        return BiliResult.oK();
    }

    /**
     *判断邮箱是否已被注册
     * @param email
     * @return
     */
    public BiliResult registEmailJudge(String email){
        User user=new User();
        user.setUserEmail(email);
        User userResult=userMapper.selectOne(user);
        if(userResult==null){
            return BiliResult.oK();
        }
        return BiliResult.build(201,"该邮箱已被注册");
    }

}
