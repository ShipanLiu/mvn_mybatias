package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Customer;

public interface CustomerMapper {
    Customer selectCustomerWithOrderlist(Integer customerId);
    Customer distributedQueryToMulti(Integer customerId);
}
