package com.jspProject.dto;

public class ProductDetailDTO {
    private int id;
    private String name;
    private double price;
    private String imagePath;
    private String description;  // 부가 설명 필드 추가
    private int quantity;

    public ProductDetailDTO() {}

    public ProductDetailDTO(int id, String name, double price, String imagePath, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.description = description;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
