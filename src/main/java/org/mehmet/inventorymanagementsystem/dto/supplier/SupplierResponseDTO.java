package org.mehmet.inventorymanagementsystem.dto.supplier;



public class SupplierResponseDTO {
    private final int id;
    private final String status;      // "SUCCESS" veya "FAILURE"
    private final String message;     // İşlem hakkında açıklama

    // Constructor for ResponseDTO
    public SupplierResponseDTO(int id, String status, String message) {
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
