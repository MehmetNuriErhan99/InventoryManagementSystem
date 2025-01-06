package org.mehmet.inventorymanagementsystem.dto.supplier;

public class SupplierResponseDTO {
    private int id; // Supplier ID
    private String name; // Supplier Name
    private String emailAddress; // Supplier Email
    private String phoneNumber; // Supplier Phone Number
    private String photo; // Supplier Photo (optional)

    public SupplierResponseDTO(int id, String name, String emailAddress, String phoneNumber, String photo) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
