package com.itguigu.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;

public class MybatisTest {
    @Test
    public void testHelloWorld() throws IOException {
        // 01 使用没有把提升的 Resource 类读取 Mybatis全局配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 02 create  SqlSessionFactoryBuilder Object, names "builder"
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 03 create sessionFactory Object by useing builder
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        // 04 create a session by useing sessionFactory
        SqlSession sqlSession = sessionFactory.openSession();
        // 05 use this seesion to do with the sql
        // statement : Mapper哦配置文件namespace属性.sql标签的id属性
        // parameter : 给 sql语句传入所需要的参数， 不如传进 id 为 1
        Object o = sqlSession.selectOne("com.atguigu.mybatis.dao.EmployeeMapper.selectEmpById", "1");

        // 06 just print
        System.out.println("object is = " + o);
        // 07 提交事务
        sqlSession.commit();
        // 08 关闭
        sqlSession.close();

        /*
        * summary :   agter using spring, we don't have to care about  01-05, so don' worry about the difficulty.
        * */


    }
}
