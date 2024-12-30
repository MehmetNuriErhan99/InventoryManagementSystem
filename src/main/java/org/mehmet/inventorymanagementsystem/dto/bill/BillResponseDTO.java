package org.mehmet.inventorymanagementsystem.dto.bill;

public class BillResponseDTO {
    private final int id;
    private final String status;
    private final String message;

    // Constructor for ResponseDTO
    public BillResponseDTO(int id, String status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    // Getters only (No setters, to keep it immutable)
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
