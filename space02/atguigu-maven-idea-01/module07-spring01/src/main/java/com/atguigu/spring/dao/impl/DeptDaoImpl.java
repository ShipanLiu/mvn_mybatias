/*
* 这里是实现类， 真正实现功能的
*
* */

package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.DeptDao;
import com.atguigu.spring.pojo.Dept;

public class DeptDaoImpl implements DeptDao {

    @Override
    public void insertDept(Dept dept) {
        System.out.println("add dept with sucess");
    }

}
