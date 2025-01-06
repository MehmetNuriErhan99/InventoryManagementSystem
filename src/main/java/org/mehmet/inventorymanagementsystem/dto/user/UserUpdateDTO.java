package org.mehmet.inventorymanagementsystem.dto.user;

public class UserUpdateDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private String photo;

    // Default constructor
    public UserUpdateDTO() {
    }

    // Parameterized constructor
    public UserUpdateDTO(int id, String name, String email, String password, String role, String phoneNumber, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
