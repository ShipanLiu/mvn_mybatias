package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.DeptDao;
import com.atguigu.spring.dao.impl.DeptDaoImpl;
import com.atguigu.spring.pojo.Dept;
import com.atguigu.spring.service.DeptService;

/**
 *  DeptService 的实现类
 */

public class DeptServiceImpl implements DeptService{


    //you need one Dept,之前的写法， 不好
    //private DeptDao deptDao = new DeptDaoImpl();

    // DeptDao 是属于 非字面量值， 可以自动装配
    private DeptDao deptDao;



    @Override
    public void saveDept(Dept dept) {
        // only for show
        deptDao.insertDept(dept);
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}