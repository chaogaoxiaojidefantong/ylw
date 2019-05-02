package com.canteen.adminService.dao;
import com.canteen.common.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
    public Integer batchDel(@Param("userList") String[] userList);
    
}