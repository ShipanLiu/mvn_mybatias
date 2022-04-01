package com.atguigu.mybatis.entity;

public class TOrder {
    private Integer orderId;
    private String orderName;
    private TCustomer customer;

    public TOrder() {
    }

    public TOrder(Integer orderId, String orderName, TCustomer customer) {
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

    public TCustomer getCustomer() {
        return customer;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setCustomer(TCustomer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "TOrder{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
