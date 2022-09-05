package com.atguigu.mybatis.entity;

public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;
//    oder 里面肯定有 Customer 属性。 order 相对于 customer 是属于多的一端， 所以引用。
    // 指挥出现 多对一， 或者多对多  不会出现 一对多（即在 少的一方加上对方）
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderId, String orderName, Integer customerId) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}




