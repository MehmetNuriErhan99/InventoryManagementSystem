package org.mehmet.inventorymanagementsystem.model;

public class Retailer {
    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private String photo;

    public Retailer(int id, String name, String phoneNumber, String emailAddress, String password, String photo) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.photo = photo;
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

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }


}
