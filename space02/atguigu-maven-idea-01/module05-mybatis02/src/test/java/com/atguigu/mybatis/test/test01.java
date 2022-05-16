package com.atguigu.mybatis.test;

import com.atguigu.mybatis.entity.Order;
import com.atguigu.mybatis.mapperInterface.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class test01 {

    private SqlSession session;
    @Before
    public void init() throws IOException {
        // init
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }

    @Test
    // just test connection
    public void testQuery() {
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        // select the order_id is 1;
        Order order = mapper.selectOrderOnly(1);
        System.out.println("order = " + order);
    }





}
