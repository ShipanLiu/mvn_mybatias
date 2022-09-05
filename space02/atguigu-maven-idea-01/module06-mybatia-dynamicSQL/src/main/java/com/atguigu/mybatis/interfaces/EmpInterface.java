package com.atguigu.mybatis.interfaces;

import com.atguigu.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface EmpInterface {
    List<Emp> selectEmpBycondition(Emp condition);
    Integer updateEmpConditional(Emp condition);
    List<Emp> selectEmpConditionalbyTrim(Emp condition);
    List<Emp> testSelectEmpByChooseWhenOtherwise(Emp condition);
    /*给 List<Emp> empList  起一个注解*/
    void batchInsert(@Param("empList") List<Emp> empList);
    void batchUpdate(@Param("empList") List<Emp> empList);
}
