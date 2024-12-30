package org.mehmet.inventorymanagementsystem.dto.bill;



import java.util.Date;

public class BillCreateRequestDTO {
    private final int supplierId;
    private final int retailerId;
    private final int productId;
    private final int amount;
    private final double currentPrice;
    private final Date date;

    // Constructor for CreateRequestDTO
    public BillCreateRequestDTO(int supplierId, int retailerId, int productId, int amount, double currentPrice, Date date) {
        this.supplierId = supplierId;
        this.retailerId = retailerId;
        this.productId = productId;
        this.amount = amount;
        this.currentPrice = currentPrice;
        this.date = new Date(date.getTime());  // Immutable Date
    }

    // Getters only (No setters, to keep it immutable)
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
