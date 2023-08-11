package com.gamestore.repository;

import com.gamestore.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByCartId(Long cartId);
    Optional<CartItem> findByProductId(Long productId);


}
