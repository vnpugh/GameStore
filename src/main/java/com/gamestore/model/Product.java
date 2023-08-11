package com.gamestore.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column

    private String productDescription;
    @Column

    private Double productPrice;
    @Column

    private int productQuantity;
    @Column

    private LocalDate dateProductAdded;

    //A product can only belong to ONE category.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    public Product() {
    }

    public Product(Long id, String productName, String productDescription, Double productPrice,
                   int productQuantity, LocalDate dateProductAdded, Category category) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.dateProductAdded = dateProductAdded;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public LocalDate getDateProductAdded() {
        return dateProductAdded;
    }

    public void setDateProductAdded(LocalDate dateProductAdded) {
        this.dateProductAdded = dateProductAdded;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", dateProductAdded=" + dateProductAdded +
                ", category=" + category +
                '}';
    }
}
