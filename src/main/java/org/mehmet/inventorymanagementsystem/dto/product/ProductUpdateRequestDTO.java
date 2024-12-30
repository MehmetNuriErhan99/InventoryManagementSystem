package org.mehmet.inventorymanagementsystem.dto.product;



public class ProductUpdateRequestDTO {
    private final int id;  // Product ID to update
    private final String name;
    private final int stockQuantity;
    private final double price;
    private final double discount;

    // Constructor for UpdateRequestDTO
    public ProductUpdateRequestDTO(int id, String name, int stockQuantity, double price, double discount) {
        this.id = id;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.discount = discount;
    }

    // Getters only (No setters, to keep it immutable)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}
