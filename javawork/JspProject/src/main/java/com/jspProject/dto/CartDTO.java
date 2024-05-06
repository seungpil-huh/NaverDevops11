package com.jspProject.dto;

public class CartDTO {
    private int userId;
    private int productId;
    private int quantity;

    // 기본 생성자
    public CartDTO() {}

    // 매개변수를 받는 생성자
    public CartDTO(int userId, int productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    // userId에 대한 getter와 setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // productId에 대한 getter와 setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    // quantity에 대한 getter와 setter
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
