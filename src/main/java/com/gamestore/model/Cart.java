package com.gamestore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //A cart can only have one user
    @OneToOne
    @JsonIgnore //useful to avoid circular references
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //One cart can have many cart items
    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart(Long id, User user, List<CartItem> cartItems) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems;
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }



    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", cartItems=" + cartItems +
                '}';
    }
}
