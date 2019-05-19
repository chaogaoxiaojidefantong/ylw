package com.canteen.adminService.controller;

import com.canteen.adminService.service.CommentService;
import com.canteen.common.pojo.Comment;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Comment/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("addOne")
    public BiliResult addOne(Comment comment){
        return commentService.addOne(comment);
    }

    @RequestMapping("selectMany")
    public BiliResult selectMany(Integer canteenId){
        return commentService.selectMany(canteenId);
    }
}
