package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    Book findByBookName(String bookName);
    Book findByBookId(int id);
    List<Book> findAllByOrderByBookNameAsc();
    List<Book> findAllByOrderByBookNameDesc();






}
