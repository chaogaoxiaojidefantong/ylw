package com.canteen.adminService.dao;

import com.canteen.common.pojo.Address;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AddressMapper extends Mapper<Address> {
    public Integer updateOne(Address address);
}
