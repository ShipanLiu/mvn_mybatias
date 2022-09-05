package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Order;

public interface OrderMapper {
    Order selectMyOrder(Integer orderId);
    Order selectOrderWithCustomer(Integer orderId);
    Order distributedselect(Integer orderId);
}
