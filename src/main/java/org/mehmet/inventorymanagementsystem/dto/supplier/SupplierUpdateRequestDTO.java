package org.mehmet.inventorymanagementsystem.dto.supplier;


public class SupplierUpdateRequestDTO {
    private final int id;  // Supplier ID to update
    private final String name;
    private final String phoneNumber;
    private final String emailAddress;
    private final String password;
    private final String photo;

    // Constructor for UpdateRequestDTO
    public SupplierUpdateRequestDTO(int id, String name, String phoneNumber, String emailAddress, String password, String photo) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.photo = photo;
    }

    // Getters only (No setters, to keep it immutable)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }
}
