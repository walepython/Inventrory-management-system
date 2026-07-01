package com.example.Inventory.Management.System.dto;

import com.example.Inventory.Management.System.model.Category;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
    private String name;
    private Category category;
    private int availableQuantity;
    private double unitPrice;
    private MultipartFile image;

    public ProductDTO() {
    }

    public ProductDTO(String name, Category category, int availableQuantity, double unitPrice, MultipartFile image) {
        this.name = name;
        this.category = category;
        this.availableQuantity = availableQuantity;
        this.unitPrice = unitPrice;
        this.image = image;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
