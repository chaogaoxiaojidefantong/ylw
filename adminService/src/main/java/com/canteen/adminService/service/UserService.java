package com.canteen.adminService.service;
import com.canteen.adminService.dao.UserMapper;
import com.canteen.common.pojo.User;
import com.canteen.common.util.JsonUtil;
import com.canteen.common.vo.BiliResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public JsonUtil<User> jsonUtil=new JsonUtil();

    Jedis jedis=new Jedis();

    public BiliResult login(User user){
    String userPwd=user.getUserPwd();
    user.setUserPwd(DigestUtils.md5Hex(userPwd));
    User user1=userMapper.selectOne(user);
    if(user1==null){
        return    BiliResult.build(201,"登录有误");
    }
    else{
        Map map=handleToken(user1);
        return  BiliResult.oK(map);
    }
}

    public BiliResult regist(User user){
        user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()));
        Integer i1=userMapper.insert(user);
        if(i1==0){
           return BiliResult.build(201,"注册失败");
        }
        return BiliResult.oK();
    }

    /**
     * 更改用户信息
     */
    public BiliResult updateUser(User user){
        Integer i1=userMapper.updateByPrimaryKey(user);
        if(i1==0){
            return BiliResult.build(201,"更新失败");
        }
        return BiliResult.oK();
    }

    /**
     * 批量删除用户
     * @param users
     * @return
     */
    public BiliResult batchDel(String users){
        Integer i1=userMapper.batchDel(users.split(","));
        if(i1==0){
            return BiliResult.build(201,"删除失败");
        }
        return BiliResult.oK();
    }


    public BiliResult userList(User user){
        return BiliResult.oK(userMapper.select(user));
    }

    public BiliResult selectOne(User user){
        return BiliResult.oK(userMapper.selectOne(user));
    }

    public Map handleToken(User user) {
        String token=user.getUserEmail()+ UUID.randomUUID();//token的保留形式为用户邮箱+随机数
        String JsonUser2=jsonUtil.writeObjToJsonString(user);//转为JSON格式，存储到redis服务器里
        //jedisCluster.setex(token,60*60*24,JsonUser2);//保存时间为一天
        jedis.set(token,JsonUser2);
        jedis.expire(token,60*60*24);
        Map map=new HashMap();
        map.put("user",user);
        map.put("token",token);
        return map;
    }

    public BiliResult loginByToken(String token){
    String userJSON=jedis.get(token);
    User user=jsonUtil.writeJsonStringToObj(userJSON,User.class);
    return  BiliResult.oK(user);
    }

    public  BiliResult logout(String token){
        jedis.del(token);
        return BiliResult.oK();
    }

}
