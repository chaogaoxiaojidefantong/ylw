package com.canteen.adminService.service;

import com.canteen.adminService.dao.AddressMapper;
import com.canteen.common.pojo.Address;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressMapper addressMapper;

    /**
     * 添加一条地址
     * @param address
     * @return
     */
    public BiliResult addOne(Address address){
        Integer i1=addressMapper.insert(address);
        if(i1==0){
            return BiliResult.build(201,"添加失败");
        }
        return BiliResult.oK("添加成功");
    }

    /**
     * 查询某个用户保存的地址
     * @param address
     * @return
     */
    public BiliResult selectMany(Address address){
        List<Address>list=addressMapper.select(address);
        return BiliResult.oK(list);
    }

    public BiliResult deleteOne(Long addressId){
        Address address=new Address();
        address.setAddressId(addressId);
        Integer i1=addressMapper.delete(address);
        if(i1==0){
            return BiliResult.build(201,"删除失败");
        }
        return BiliResult.oK("删除成功");
    }

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    public BiliResult updateOne(Address address){
        Integer i1=addressMapper.updateOne(address);
        if(i1==0){
            return BiliResult.build(201,"删除失败");
        }
        return BiliResult.oK("修改成功");
    }

}
