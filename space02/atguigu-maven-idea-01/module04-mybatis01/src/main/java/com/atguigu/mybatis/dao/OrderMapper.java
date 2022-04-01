package com.atguigu.mybatis.dao;


import com.atguigu.mybatis.entity.TOrder;

/*here is the Mapper Interface for the customer and order*/
public interface OrderMapper {

    // 比如我查 order_id是 1 的，返回整体的Order， 里面 顺便带着这个 order属于的customer查出来
    TOrder selectOrdereWithCustomer(Integer choosedOrderId);

}
