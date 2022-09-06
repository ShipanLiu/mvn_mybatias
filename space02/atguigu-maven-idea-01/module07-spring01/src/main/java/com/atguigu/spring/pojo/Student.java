package com.atguigu.spring.pojo;

public class Student {

    private Integer stuId;
    private String stuName;

    public Student() {   // 无参构造器 就是 为了 Student.class 用的
    }

    public Student(Integer stuId, String stuName) {
        //System.out.println(" 你在使用 constructor");
        this.stuId = stuId;
        this.stuName = stuName;
    }

    public Integer getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuId(Integer stuId) {
        //System.out.println("you are using Set method");
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
