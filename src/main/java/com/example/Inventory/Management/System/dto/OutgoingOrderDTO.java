package com.example.Inventory.Management.System.dto;

public class OutgoingOrderDTO {
   private int productId;
   private int quantityOrder;
   private double discount;

    public OutgoingOrderDTO() {
    }

    public OutgoingOrderDTO(int productId, int quantityOrder, double discount) {
        this.productId = productId;
        this.quantityOrder = quantityOrder;
        this.discount = discount;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
