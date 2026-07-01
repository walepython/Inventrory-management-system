package com.example.Inventory.Management.System.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int availableQuantity;
    private double unitPrice;
    private double totalPrice;
    private String imageUrl;
    @CreationTimestamp
    private String dateCreated;

    public Product() {
    }

    public Product( String name, Category category, int availableQuantity, double unitPrice,String imageUrl) {

        this.name = name;
        this.category = category;
        this.availableQuantity = availableQuantity;
        this.unitPrice = unitPrice;
        this.totalPrice = unitPrice * availableQuantity;
        this.imageUrl = imageUrl;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + category +
                ", availableQuantity=" + availableQuantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
