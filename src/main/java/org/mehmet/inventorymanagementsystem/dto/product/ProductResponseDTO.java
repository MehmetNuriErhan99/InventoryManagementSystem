package org.mehmet.inventorymanagementsystem.dto.product;



public class ProductResponseDTO {
    private final int id;
    private final String name;
    private final double price;
    private final String status;

    // Constructor for ResponseDTO
    public ProductResponseDTO(int id, String name, double price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    // Getters only (No setters, to keep it immutable)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
