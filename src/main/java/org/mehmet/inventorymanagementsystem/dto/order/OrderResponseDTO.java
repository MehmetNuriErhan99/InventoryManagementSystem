package org.mehmet.inventorymanagementsystem.dto.order;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private int id;
    private int supplierId;
    private int retailerId;
    private int productId;
    private int amount;
    private String orderStatus;
    private LocalDateTime createdAt;

    public OrderResponseDTO(int id, int supplierId, int retailerId, int productId, int amount, String orderStatus, LocalDateTime createdAt) {
        this.id = id;
        this.supplierId = supplierId;
        this.retailerId = retailerId;
        this.productId = productId;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public OrderResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}