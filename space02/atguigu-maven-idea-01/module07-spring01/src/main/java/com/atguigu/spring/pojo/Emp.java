package com.atguigu.spring.pojo;

public class Emp {
    private Integer id;
    private String lastName;
    private String email;
    private Double salary;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer id, String lastName, String email, Double salary, Dept dept) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }

    public Dept getDept() {
        return dept;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}
