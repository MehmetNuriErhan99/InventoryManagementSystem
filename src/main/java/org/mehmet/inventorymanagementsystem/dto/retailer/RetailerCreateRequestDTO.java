package org.mehmet.inventorymanagementsystem.dto.retailer;
public class RetailerCreateRequestDTO {
    private final String name;
    private final String phoneNumber;
    private final String emailAddress;
    private final String password;
    private final String photo;

    // Constructor for CreateRequestDTO
    public RetailerCreateRequestDTO(String name, String phoneNumber, String emailAddress, String password, String photo) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.photo = photo;
    }

    // Getters only (No setters, to keep it immutable)
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