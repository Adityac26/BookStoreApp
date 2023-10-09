package com.bridgelabz.bookstoreapp.dto;

public class BookDto {

    public String bookName;
    public String author;
    public String bookDescription;
    public String bookImg;
    public int price;
    public int quantity;

    public BookDto(String bookName, String author, String bookDescription, String bookImg, int price, int quantity) {
        this.bookName = bookName;
        this.author = author;
        this.bookDescription = bookDescription;
        this.bookImg = bookImg;
        this.price = price;
        this.quantity = quantity;
    }
}
