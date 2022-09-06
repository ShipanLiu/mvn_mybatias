package com.atguigu.spring.pojo;

import java.util.List;
import java.util.Map;

public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Emp> empList;
    // 为了演示和 List的区别,引入Map
    private Map<Integer,Emp> empMap;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName, List<Emp> empList, Map<Integer, Emp> empMap) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
        this.empMap = empMap;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public Map<Integer, Emp> getEmpMap() {
        return empMap;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public void setEmpMap(Map<Integer, Emp> empMap) {
        this.empMap = empMap;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                ", empMap=" + empMap +
                '}';
    }
}
