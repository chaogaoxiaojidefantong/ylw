package com.canteen.adminService.dao;
import com.canteen.common.pojo.Cart;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface CartMapper extends Mapper<Cart> {
    public  Integer updateAllPrice(Cart cart);
}
