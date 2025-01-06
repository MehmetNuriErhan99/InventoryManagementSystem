package org.mehmet.inventorymanagementsystem.dto.cart;

public class CartCreateRequestDTO {

    private final int retailerId;
    private final int productId;
    private final int quantity;

    public CartCreateRequestDTO(int retailerId, int productId, int quantity) {
        this.retailerId = retailerId;
        this.productId = productId;
        this.quantity = quantity;
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
