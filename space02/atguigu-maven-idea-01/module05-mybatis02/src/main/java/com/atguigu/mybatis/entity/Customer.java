package com.atguigu.mybatis.entity;

import java.util.List;

public class Customer {
    private  Integer customerId;
    private  String customerName;
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, List<Order> orderList) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderList = orderList;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "TCustomer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
