package org.mehmet.inventorymanagementsystem.model;

public class Cart {

    private final int id;
    private final int retailerId;
    private final int productId;
    private final int quantity;

    public Cart(int id, int retailerId, int productId, int quantity) {
        this.id = id;
        this.retailerId = retailerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
