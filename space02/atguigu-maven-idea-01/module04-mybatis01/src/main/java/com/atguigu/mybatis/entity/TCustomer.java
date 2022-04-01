package com.atguigu.mybatis.entity;

import java.util.List;

public class TCustomer {
    private  Integer customerId;
    private  String customerName;
    private List<TOrder> orderList;

    public TCustomer() {
    }

    public TCustomer(Integer customerId, String customerName, List<TOrder> orderList) {
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

    public List<TOrder> getOrderList() {
        return orderList;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderList(List<TOrder> orderList) {
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
