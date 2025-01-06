package org.mehmet.inventorymanagementsystem.dto.cart;

public class CartResponseDTO {

    private final int id;
    private final int retailerId;
    private final int productId;
    private final int quantity;

    public CartResponseDTO(int id, int retailerId, int productId, int quantity) {
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
