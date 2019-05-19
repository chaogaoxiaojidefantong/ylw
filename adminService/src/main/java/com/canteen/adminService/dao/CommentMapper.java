package com.canteen.adminService.dao;

import com.canteen.common.pojo.Comment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface CommentMapper extends Mapper<Comment> {
}
