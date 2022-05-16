package com.atguigu.mybatis.entity;

public class Order {
    private Integer orderId;
    private String orderName;
    // 注意这边我放的是 Customer 对象。不是 customerID
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderId, String orderName, Customer customer) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.customer = customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
