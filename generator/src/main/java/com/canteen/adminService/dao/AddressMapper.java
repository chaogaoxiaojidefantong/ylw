package com.canteen.adminService.dao;

import com.canteen.common.pojo.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Long addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}