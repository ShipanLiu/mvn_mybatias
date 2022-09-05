package com.atguigu.mybatis.test;


import com.atguigu.mybatis.entity.Customer;
import com.atguigu.mybatis.entity.Order;
import com.atguigu.mybatis.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test01 {
    private SqlSession session;

    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                // 引入配置文件
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }

    @Test
    public void testQueryOrder() {
        // 有 customerMapper， 也有 OrderMapper
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        // 需要在 对应的interface里面加上selectMyOrder 方法。
        Order order =  orderMapper.selectMyOrder(1);
        System.out.println("order=" + order);
    }

    @Test
    public void testQueryOrderWithCustomer() {
        // if I want to operate order, then I need to get the OrderMapper.xml(the sqls are saved in it)
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Integer orderId = 1;
        // we need to desine this method intership
        Order order = orderMapper.selectOrderWithCustomer(orderId);

        // print the info of the order
        System.out.println("the order is: " + order.toString());
        // print the info about customer specifically
        System.out.println("the customer that owns this order is: " + order.getCustomer().toString());
    }
    @Test
    public void testQueryCustomerWithOrderList() {
        //  这样 customMapper 就能得到 intercace 里面的方法；
         CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        //目标： 查询 custom对象的同时， 连同Customer 对象关联的集合也查出来。
        Integer customerId = 1;
        Customer customer = customerMapper.selectCustomerWithOrderlist(customerId);

        // print customer
        System.out.println(customer.toString());

        // print order list
        List<Order> orderList = customer.getOrderList();
        System.out.println(orderList.size());
        for(Order order : orderList) {
            System.out.println("order =  " + order);
        }
    }

//    对一的 分布查询
    @Test
    public void distributedQueryToOne() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

        Integer orderId = 1;
        Order order = orderMapper.distributedselect(orderId);

        //get customer via Order
        Customer customer = order.getCustomer();

        System.out.println("order = " + order);
        System.out.println("customer = " + customer );
    }


    //    对多的 分布查询(肯定在 customerMapper 里面操作)
    @Test
    public void distributedQueryToMulti() throws InterruptedException {
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Integer customerId = 1;
        Customer customer = customerMapper.distributedQueryToMulti(customerId);

        // 测试延迟加载时候， 不要打印整个customer， 这样mybatis 会查询customer 下面的Order。
        //System.out.println("customer : " + customer);

        Integer cId = customer.getCustomerId();
        String cName = customer.getCustomerName();
        System.out.println("cId" + cId);
        System.out.println("cName" + cName);

        // 睡觉三秒
        TimeUnit.SECONDS.sleep(3);

        List<Order> orderList = customer.getOrderList();
        for(Order order : orderList) {
            System.out.println("order is: " + order);
        }
    }

}
