package org.mehmet.inventorymanagementsystem.model;


public class Product {

    private int id;
    private String name;
    private int stockQuantity;
    private double price;
    private double discount;

    public Product(int id, String name, int stockQuantity, double price, double discount) {
        this.id = id;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.discount = discount;
    }

    public Product() {
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


    public static Product searchProductByName(String name) {
        return null;
    }

    public void viewProductDetail() {
        System.out.println("Product Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Stock Quantity: " + stockQuantity);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + discount);
    }
}
