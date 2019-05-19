package com.canteen.adminService.service;

import com.canteen.adminService.dao.CommentMapper;
import com.canteen.adminService.dao.OrdMapper;
import com.canteen.adminService.dao.UserMapper;
import com.canteen.adminService.util.EasyUtil;
import com.canteen.common.pojo.Comment;
import com.canteen.common.pojo.Ord;
import com.canteen.common.pojo.User;
import com.canteen.common.pojoVo.CommentVo;
import com.canteen.common.pojoVo.OrderVo;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrdMapper ordMapper;

    EasyUtil easyUtil=new EasyUtil();

    /**
     * 评论
      * @param comment
     * @return
     */
    public BiliResult addOne(Comment comment){
    Integer i1=commentMapper.insert(comment);
    if(i1==0){
        return BiliResult.build(201,"评论失败");
    }
        Ord order=new OrderVo();
        order.setOrderId(comment.getOrderId());
        order.setOrderState(3);
    ordMapper.updateState(order);
    return BiliResult.oK();
    }

    /**
     * 查询某个食堂的评论
     * @param canteenId
     * @return
     */
    public BiliResult selectMany(Integer canteenId){
    Comment comment=new Comment();
    comment.setCanteenId(canteenId);
    List<Comment>commentList=commentMapper.select(comment);
    List<CommentVo>commentVoList=new ArrayList<>();
    for(Comment comment1:commentList){
        User user=new User();
        user.setUserId(comment1.getUserId());
        User userResult=userMapper.selectOne(user);
        CommentVo commentVo=easyUtil.getCommentVo(comment1);
        commentVo.setUser(userResult);
        Ord order=new Ord();
        order.setOrderId(comment1.getOrderId());
        Ord orderResult=ordMapper.selectOne(order);
        commentVo.setOrder(orderResult);
        commentVoList.add(commentVo);
    }
    return BiliResult.oK(commentVoList);
    }




}
