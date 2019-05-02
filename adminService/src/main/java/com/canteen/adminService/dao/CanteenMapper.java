package com.canteen.adminService.dao;

import com.canteen.common.pojo.Canteen;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CanteenMapper extends Mapper<Canteen> {
    public Integer deleteCanteen(@Param("canteenIds") String canteenIds[]);

    public Integer updateCanteen(Canteen canteen);
    //通过名字的模糊查询
    public List<Canteen> selectByName(@Param("canteenName")String canteenName);

    public  Integer updateCanteenTest(Canteen canteen);
}