package org.mehmet.inventorymanagementsystem.dto.product;

public class ProductCreateRequestDTO {
    private String name;
    private int stockQuantity;
    private double price;
    private double discount;

    public ProductCreateRequestDTO() {}

    public ProductCreateRequestDTO(String name, int stockQuantity, double price, double discount) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
