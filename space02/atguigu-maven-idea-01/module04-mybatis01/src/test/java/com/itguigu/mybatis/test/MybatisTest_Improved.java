package com.itguigu.mybatis.test;

import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.OrderMapper;
import com.atguigu.mybatis.entity.Emp;
import com.atguigu.mybatis.entity.TOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisTest_Improved {

    private SqlSession session;

    // junit会在每一个 @Test之前执行 @Test的方法
    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    }

    @After
    public void clear() {
        // if you do not commit, the value in mysql will not change
        session.commit();
        session.close();
    }


    /*  大卫天龙 */



    /*测试 com.atguigu.mybatis.dao/EmployeeMapper这个 接口,*/
    @Test
    public void testSelect() {

        // 01 获取 employeeMapper 对象
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        //我们顺便想要知道 EmployeeMapper 的接口的类的名字是什么
        //System.out.println(employeeMapper.getClass().getName());   // com.sun.proxy.$Proxy11(这种就是框架商城的 动态实现类)
        // 因为你没有定义 实现类， 只是定义了 employeeMapper 这个接口

        // 调用 employeeMapper 这个接口的方法(方法我们之前已经在这个interface里面定义好了)， 完成对数据库v库的操作
        Emp emp = employeeMapper.selectEmpById(1);

        // 打印一下 查询的结果
        System.out.println(emp);

    }


    /*测试 insert*/
    @Test
    public void testInsert() {
        // 先得到这个接口
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 再执行接口下面的方法
        int rowCount = employeeMapper.insertEmp(new Emp(null, "jiba2", 30.00));
        System.out.println("rowCount = " + rowCount);
    }


    @Test
    public void testDelete() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        employeeMapper.deleteById(3);
    }

    @Test
    public void testUpdate() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        employeeMapper.updateById(new Emp(2, "jibadan", 100.00));
    }


    // 采用注解的方式
    @Test
    public void testUpdateUsingMorePrams() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        employeeMapper.updateEmployeeWithAnnotation("jibadan", 999);
    }

    // 采用Map的方式, 当参数四五个以上的时候
    @Test
    public void testUpdateUsingMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("key_empId", 2);
        paraMap.put("key_empName", "jier");
        paraMap.put("key_empSalary", 1001);

        employeeMapper.updateEmployeeWithMap(paraMap);
    }


    /*         For      Return      */



    // 测试输出时候，return a simple data type
    @Test
    public void testSelectCount() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer count = employeeMapper.selectCount();
        System.out.println("The counrt is : " + count);
    }

    // by returning entity class object
    @Test
    public void testRetuenOneEmp() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp oneEmp = employeeMapper.returnOneEmp(2);
        System.out.println(oneEmp.toString());
    }

    // if can not return an entity, then we can return a Map
    @Test
    public void testRetuenMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> mapResult = employeeMapper.returnMap(2);
        Set<String> keys = mapResult.keySet();
        for(String str : keys) {
            Object value = mapResult.get(str);
            System.out.println("value = " + value);
        }
    }

    // 查询所有的user，并且把这些 user 放到一个list 里面。
    @Test
    public void testReturnList() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = employeeMapper.returnList();
        for(Emp emp : empList) {
            System.out.println("emp : " + emp);
        }
    }

    // 查自增主键
    @Test
    public void testGetGeneratedKey() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp emp = new Emp(null, "Jiujo", 888.00);
        int rowCount = employeeMapper.insertWithKey(emp);
        System.out.println("rowCount is : " + rowCount);
        // 自增的主键 会放到 emp 对象的 empId 里面。
        // 不要通过查询来获得 empId（应该用自增主键的方式）， 因为会在并发发情况下 出错
        System.out.println("empId is : " + emp.getEmpId());
    }



    @Test
    public void testSelectWithResultMap() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = employeeMapper.selectWithReasltMap();
        for(Emp emp : empList) {
            System.out.println(emp.toString());
        }
    }


    /* here is for testing the customer and orders*/

    @Test
    public void testOrderWithCustomer() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        TOrder order = orderMapper.selectOrdereWithCustomer(1);
        System.out.println("the order is: " + order.toString());
        System.out.println("the customer is: " + order.getCustomer());
        // TOrder{orderId=1, orderName='o1', customer=TCustomer{customerId=1, customerName='c01', orderList=null}}
    }












}
