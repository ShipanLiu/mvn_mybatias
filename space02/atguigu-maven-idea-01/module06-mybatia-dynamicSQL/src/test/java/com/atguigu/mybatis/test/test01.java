package com.atguigu.mybatis.test;

import com.atguigu.mybatis.entity.Emp;
import com.atguigu.mybatis.interfaces.EmpInterface;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test01 {

    private SqlSession session;

    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }

    @Test
    public void testQueryEmp() {
        EmpInterface empMapper = session.getMapper(EmpInterface.class);

        Emp condition = new Emp();
        // condition 1 :   emp_name != null + emp_salary > 1000
        condition.setEmpName("jiba1");
        condition.setEmpSalary(1000.00);  //<if test="empSalary &gt; 1002">  你给我 1000
                                            // 说明不满足 条件， 所以第二个条件就不会取查
                                        // DEBUG 09-04 11:10:09,279 ==>  Preparing: select emp_id,emp_name,emp_salary from Emp WHERE emp_name=?

        List<Emp> empList = empMapper.selectEmpBycondition(condition);

        for(Emp emp : empList) {
            System.out.println("emp: " + emp);
        }
    }

    @Test
    public void testUpdateEmpConditional() {
        EmpInterface empMapper = session.getMapper(EmpInterface.class);

        Emp condition = new Emp();

//        condition.setEmpName("jiba04");
//        condition.setEmpSalary(600.00);

        condition.setEmpName(null);
        condition.setEmpSalary(9999.00);
        Integer updatedId = empMapper.updateEmpConditional(condition);

        System.out.println("the updated user is: " + updatedId);
    }

    @Test
    public void testSelectEmpConditional() {
        EmpInterface empMapper = session.getMapper(EmpInterface.class);

        Emp condition = new Emp();

        condition.setEmpName("jiba1");
        condition.setEmpSalary(1001.00);

        List<Emp> empList = empMapper.selectEmpConditionalbyTrim(condition);

        for(Emp emp : empList) {
            System.out.println("emp:" + emp);
        }

    }

    @Test
    public void testSelectEmpByChooseWhenOtherwise() {
        EmpInterface empMapper = session.getMapper(EmpInterface.class);

        Emp condition = new Emp();

        condition.setEmpName(null);
        condition.setEmpSalary(1001.00);

        List<Emp> empList = empMapper.testSelectEmpByChooseWhenOtherwise(condition);

        for(Emp emp : empList) {
            System.out.println("emp:" + emp);
        }
    }

//    批次insert
    @Test
    public void testBatchInsert() {
        EmpInterface empMapper = session.getMapper(EmpInterface.class);

        List<Emp> empList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Emp emp = new Emp(null, "tiger"+i, 1100.00*i);
            empList.add(emp);
        }

        empMapper.batchInsert(empList);
    }

    /*批量更新*/
    @Test
    public void testBatchUpdate() {
        EmpInterface empMapper = session.getMapper(EmpInterface.class);

        List<Emp> empList = new ArrayList<>();

        for (int i = 7; i < 10; i++) {
            Emp emp = new Emp(i, "bigTiger"+i, 1500.00*i);
            empList.add(emp);
        }

        empMapper.batchUpdate(empList);
    }






}
