package com.gamestore.repository;


import com.gamestore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
 Optional<Cart> findByUserId(Long userId);

}
