package com.gamestore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Need to tag items with the cart they belong to
    //Each item is linked to one specific cart
    //Every item must have a cart (nullable = false)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    //Each item is linked to only one product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productName;

    @Column
    private int quantity;

    public CartItem() {
    }

    public CartItem(Long id, Cart cart, Product productName, int quantity) {
        this.id = id;
        this.cart = cart;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProductName() {
        return productName;
    }

    public void setProductName(Product productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cart=" + cart +
                ", productName=" + productName +
                ", quantity=" + quantity +
                '}';
    }
}
