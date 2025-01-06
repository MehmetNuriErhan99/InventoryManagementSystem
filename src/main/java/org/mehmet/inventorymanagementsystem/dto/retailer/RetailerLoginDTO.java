package org.mehmet.inventorymanagementsystem.dto.retailer;

public class RetailerLoginDTO {
    private String emailAddress;
    private String password;

    public RetailerLoginDTO(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public RetailerLoginDTO() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
