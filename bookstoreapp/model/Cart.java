package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)

    private int cartId;
    private int userId;
    private int bookId;
    private int quantity;

    public Cart(CartDto cartDto){
        this.userId= cartDto.userId;
        this.bookId = cartDto.bookId;
        this.quantity = cartDto.quantity;
    }

    public Cart() {

    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
