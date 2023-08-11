package com.gamestore.repository;

import com.gamestore.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByCartId(Long cartId);
    Optional<CartItem> findByProductId(Long productId);


}
