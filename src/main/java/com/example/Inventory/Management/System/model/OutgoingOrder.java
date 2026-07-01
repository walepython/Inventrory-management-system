package com.example.Inventory.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class OutgoingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int quantityOrder;
    private double totalPriceBeforeDiscount;
    private double discount;
    private double totalPriceAfterDiscount;
    @CreationTimestamp
    private String orderDate;

    public OutgoingOrder() {
    }

    public OutgoingOrder(int productId, int quantityOrder, double totalPriceBeforeDiscount, double discount, double TotalPriceAfterDiscount) {
        this.productId = productId;
        this.quantityOrder = quantityOrder;
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        this.discount = discount;
        this.totalPriceAfterDiscount = TotalPriceAfterDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public double getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public void setTotalPriceBeforeDiscount(double totalPriceBeforeDiscount) {
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(double getTotalPriceAfterDiscount) {
        this.totalPriceAfterDiscount = getTotalPriceAfterDiscount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OutgoingOrder{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantityOrder=" + quantityOrder +
                ", totalPriceBeforeDiscount=" + totalPriceBeforeDiscount +
                ", discount=" + discount +
                ", totalPriceAfterDiscount=" + totalPriceAfterDiscount +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
