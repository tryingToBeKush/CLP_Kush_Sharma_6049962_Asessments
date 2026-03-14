package cg.demo.association.test;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="abes_order")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    private String orderName;
    private double orderAmount;
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {}

    public Order(int orderId, String orderName, double orderAmount, Date orderDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getOrderName() { return orderName; }
    public void setOrderName(String orderName) { this.orderName = orderName; }

    public double getOrderAmount() { return orderAmount; }
    public void setOrderAmount(double orderAmount) { this.orderAmount = orderAmount; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}