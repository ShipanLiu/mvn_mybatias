/*
* 这个Dao文件夹 相当于 mybatis 里面的mapperInterface
*
* */

package com.atguigu.spring.dao;

import com.atguigu.spring.pojo.*;

public interface DeptDao {
    /*写一些相关的功能*/

    // add dept
    public void insertDept(Dept dept);
}
