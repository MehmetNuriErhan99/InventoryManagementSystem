package org.mehmet.inventorymanagementsystem.dto.retailer;


public class RetailerResponseDTO {
    private final int id;
    private final String name;
    private final String emailAddress;
    private final String status;

    public RetailerResponseDTO(int id, String name, String emailAddress, String status) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStatus() {
        return status;
    }
}
