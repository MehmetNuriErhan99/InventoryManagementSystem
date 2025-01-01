package org.mehmet.inventorymanagementsystem.model;

public class Supplier {

    private final int id;
    private final String name;
    private final String phoneNumber;
    private final String emailAddress;
    private final String password;
    private final String photo;

    public Supplier(int id, String name, String phoneNumber, String emailAddress, String password, String photo) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.photo = photo;
    }

    // Constructor without ID
    public Supplier(String name, String phoneNumber, String emailAddress, String password, String photo) {
        this(0, name, phoneNumber, emailAddress, password, photo);
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

