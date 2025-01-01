package org.mehmet.inventorymanagementsystem.dto.supplier;



public class SupplierResponseDTO {
    private final int id;
    private final String status;
    private final String message;

    public SupplierResponseDTO(int id, String status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

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
