package com.bridgelabz.bookstoreapp.dto;

public class CartDto {

    public int userId;
    public int bookId;
    public int quantity;

    public CartDto(int userId, int bookId, int quantity) {
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
    }
}
