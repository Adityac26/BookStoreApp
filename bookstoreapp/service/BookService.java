package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public Book insert(BookDto bookDto){
        Book book = new Book(bookDto);
        return bookRepo.save(book);
    }



    @Override
    public List<Book> getAll(){
        return bookRepo.findAll();
    }



    @Override
    public Optional<Book> getById(int id){
        return bookRepo.findById(id);
    }



    @Override
    public void delete(int id){
        bookRepo.deleteById(id);
    }



    @Override
    public Book searchByName(String bookName){
        return bookRepo.findByBookName(bookName);
    }



    @Override
    public Object update(int id,BookDto bookDto) {
        if (bookRepo.existsById(id)){
            Book book = new Book(bookDto);
            book.setBookId(id);
            Book book1 = bookRepo.save(book);
            ResponseDto responseDto = new ResponseDto("Updated successfully",book1);
            return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
        }
        else return "id not found";
    }



    @Override
    public Book updateQuantity(int id, int quantity){
        Book book = bookRepo.findByBookId(id);
        book.setQuantity(quantity);
        return bookRepo.save(book);
    }


    @Override
    public Object sortAsc(){
        return bookRepo.findAllByOrderByBookNameAsc();
    }



    @Override
    public Object sortDesc() {
        return bookRepo.findAllByOrderByBookNameDesc();
    }

}
