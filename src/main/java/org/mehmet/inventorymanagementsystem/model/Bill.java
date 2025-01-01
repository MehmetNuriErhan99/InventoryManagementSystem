package org.mehmet.inventorymanagementsystem.model;
import java.util.Date;

public class Bill {

    private final int id;
    private final int supplierId;
    private final int retailerId;
    private final int productId;
    private final int amount;
    private final double currentPrice;
    private final Date date;

    public Bill(int id, int supplierId, int retailerId, int productId, int amount, double currentPrice, Date date) {
        this.id = id;
        this.supplierId = supplierId;
        this.retailerId = retailerId;
        this.productId = productId;
        this.amount = amount;
        this.currentPrice = currentPrice;
        this.date = new Date(date.getTime());
    }

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
        return new Date(date.getTime());
    }
}
