package com.example.Inventory.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class IncomingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int supplierId;
    private int quantitySupply;
    private double unitPrice;
    private double totalPrice;
    @CreationTimestamp
    private String supplyDate;

    public IncomingOrder() {
    }

    public IncomingOrder(int productId, int supplierId, int quantitySupply,double unitPrice) {
        this.productId = productId;
        this.supplierId = supplierId;
        this.quantitySupply = quantitySupply;
        this.unitPrice = unitPrice;
        this.totalPrice = quantitySupply*unitPrice;
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getQuantitySupply() {
        return quantitySupply;
    }

    public void setQuantitySupply(int quantitySupply) {
        this.quantitySupply = quantitySupply;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(String supplyDate) {
        this.supplyDate = supplyDate;
    }

    @Override
    public String toString() {
        return "IncomingOrder{" +
                "id=" + id +
                ", productId=" + productId +
                ", supplierId=" + supplierId +
                ", quantitySupply=" + quantitySupply +
                ", unitprice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", supplyDate='" + supplyDate + '\'' +
                '}';
    }
}
