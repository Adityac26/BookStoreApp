package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)

    private int bookId;
    private String bookName;
    private String author;
    private String bookDescription;
    private String bookImg;
    private int price;
    private int quantity;


    public Book(BookDto bookDto){
        this.bookName = bookDto.bookName;
        this.author = bookDto.author;
        this.bookDescription = bookDto.bookDescription;
        this.bookImg= bookDto.bookImg;
        this.price= bookDto.price;
        this.quantity= bookDto.quantity;

    }

    public Book() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
