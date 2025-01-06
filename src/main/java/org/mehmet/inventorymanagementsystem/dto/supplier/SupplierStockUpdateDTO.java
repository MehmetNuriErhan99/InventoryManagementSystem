package org.mehmet.inventorymanagementsystem.dto.supplier;

public class SupplierStockUpdateDTO {
    private int productId; // Güncellenecek ürün ID'si
    private int newStockQuantity; // Yeni stok miktarı

    public SupplierStockUpdateDTO(int productId, int newStockQuantity) {
        this.productId = productId;
        this.newStockQuantity = newStockQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNewStockQuantity() {
        return newStockQuantity;
    }

    public void setNewStockQuantity(int newStockQuantity) {
        this.newStockQuantity = newStockQuantity;
    }

    public int getSupplierId() {
        return productId;
    }

    public String getStockAmount() {
        return null;
    }
}
