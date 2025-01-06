package org.mehmet.inventorymanagementsystem.dto.cart;

public class CartUpdateRequestDTO {
    private int id;
    private int quantity;

    public CartUpdateRequestDTO(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CartUpdateRequestDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
