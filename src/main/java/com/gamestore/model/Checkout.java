package com.gamestore.model;


import jakarta.persistence.*;

@Entity
@Table(name = "checkouts")
public class Checkout {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    //User can have only one checkout at a time
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String shippingAddress;
    @Column
    private String billingAddress;
    @Column
    private String cardHolderName;
    @Column
    private String cardNumber; //Use String because of the dashes and storing sensitive data
    @Column
    private String expiration; //Store in UTC or standardized format (e.g., "YYYY-MM")
    @Column
    private String cvv; //Store securely, encrypted
    @Column
    private Double total;

    public Checkout() {
    }

    public Checkout(Long id, User user, String firstName, String lastName, String shippingAddress,
                    String billingAddress, String cardHolderName, String cardNumber, String expiration,
                    String cvv, Double total) {
        this.id = id;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvv = cvv;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiration='" + expiration + '\'' +
                ", cvv='" + cvv + '\'' +
                ", total=" + total +
                '}';
    }
}
