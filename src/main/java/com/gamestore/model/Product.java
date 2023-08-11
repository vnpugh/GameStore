package com.gamestore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @Column
    private String productImage;

    //A product can only belong to ONE category.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    @OneToMany(mappedBy = "productName")
    @JsonIgnore
    private List<CartItem> cartItems;

    public Product() {
    }

    public Product(Long id, String productName, String productDescription, Double productPrice,
                   int productQuantity, LocalDate dateProductAdded, String productImage,
                   Category category, List<CartItem> cartItems) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.dateProductAdded = dateProductAdded;
        this.productImage = productImage;
        this.category = category;
        this.cartItems = cartItems;
    }
}
