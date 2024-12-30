package org.mehmet.inventorymanagementsystem.dto.bill;


import java.util.Date;

public class BillUpdateRequestDTO {
    private final int id;  // Bill ID to update
    private final int supplierId;
    private final int retailerId;
    private final int productId;
    private final int amount;
    private final double currentPrice;
    private final Date date;

    // Constructor for UpdateRequestDTO
    public BillUpdateRequestDTO(int id, int supplierId, int retailerId, int productId, int amount, double currentPrice, Date date) {
        this.id = id;
        this.supplierId = supplierId;
        this.retailerId = retailerId;
        this.productId = productId;
        this.amount = amount;
        this.currentPrice = currentPrice;
        this.date = new Date(date.getTime());  // Immutable Date
    }

    // Getters only (No setters, to keep it immutable)
    public int getId() {
        return id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public Date getDate() {
        return new Date(date.getTime());  // Immutable Date
    }
}
