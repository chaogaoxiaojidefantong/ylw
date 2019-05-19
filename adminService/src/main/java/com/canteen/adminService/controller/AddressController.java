package com.canteen.adminService.controller;

import com.canteen.adminService.service.AddressService;
import com.canteen.common.pojo.Address;
import com.canteen.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Address/")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("addOne")
    public BiliResult addOne(Address address){
    return  addressService.addOne(address);
    }

    @RequestMapping("selectMany")
    public BiliResult selectMany(Address address){
        return addressService.selectMany(address);
    }

    @RequestMapping("deleteOne")
    public BiliResult deleteOne(Long addressId){
        return addressService.deleteOne(addressId);
    }

    @RequestMapping("updateOne")
    public BiliResult updateOne(Address address){
        return addressService.updateOne(address);
    }


}
