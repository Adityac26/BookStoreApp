package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Integer> {
     Cart findByCartId(int id);
}
