package org.mehmet.inventorymanagementsystem.dto.retailer;

public class RetailerResponseDTO {
    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String photo;

    public RetailerResponseDTO(int id, String name, String phoneNumber, String emailAddress, String photo) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.photo = photo;
    }

    public RetailerResponseDTO() {
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
