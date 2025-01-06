package org.mehmet.inventorymanagementsystem.dto.supplier;

public class SupplierOrderResponseDTO {
    private int orderId;
    private String retailerName; // Siparişi veren satıcının adı
    private String productName; // Sipariş edilen ürün adı
    private int amount; // Sipariş miktarı
    private String orderStatus; // Sipariş durumu (Pending, Approved, Rejected)

    public SupplierOrderResponseDTO(int orderId, String retailerName, String productName, int amount, String orderStatus) {
        this.orderId = orderId;
        this.retailerName = retailerName;
        this.productName = productName;
        this.amount = amount;
        this.orderStatus = orderStatus;
    }

    public SupplierOrderResponseDTO(int id, String name, int productId, int stockAmount) {
        this.orderId = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
