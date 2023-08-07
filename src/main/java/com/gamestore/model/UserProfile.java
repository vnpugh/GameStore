package com.gamestore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Column
    private String shippingAddress;

    @Column
    private String billingAddress;

    @Column
    private String phoneNumber;

    @Column
    private String email;

        /**
         * One-To-One UserProfile to User. Every user gets a user profile that holds information.
         */
        @JsonIgnore
        @OneToOne(mappedBy = "userProfile")
        private User user;

        public UserProfile() {
        }

        public UserProfile(String shippingAddress, String billingAddress, String phoneNumber, String email) {
            this.shippingAddress = shippingAddress;
            this.billingAddress = billingAddress;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
