package com.atguigu.mybatis.mapperInterface;

import com.atguigu.mybatis.entity.Order;

public interface OrderMapper {
    Order selectOrderOnly(int orderId);
}
