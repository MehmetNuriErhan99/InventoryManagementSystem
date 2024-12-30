package org.mehmet.inventorymanagementsystem.model;

public class Product {

    private final int id;
    private final String name;
    private final int stockQuantity;
    private final double price;
    private final double discount;

    public Product(int id, String name, int stockQuantity, double price, double discount) {
        this.id = id;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.discount = discount;
    }

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

    public void setId(int id) {
    }
}
