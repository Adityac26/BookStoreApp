package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> insert(@RequestBody BookDto bookDto){
        Book book = bookService.insert(bookDto);
        ResponseDto responseDto = new ResponseDto("Data inserted",book);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @GetMapping("getAll")
    public ResponseEntity<ResponseDto> getAll(){
        List<Book> book = bookService.getAll();
        ResponseDto responseDto = new ResponseDto("Get call Successful",book);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable int id){
        Optional<Book> book = bookService.getById(id);
        ResponseDto responseDto = new ResponseDto("Get call success",book);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id){
        bookService.delete(id);
        ResponseDto responseDto= new ResponseDto("Deleted"," ");
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @GetMapping("/searchByName/{name}")
    public ResponseEntity<ResponseDto> searchByName(@PathVariable String name){
        Book book= bookService.searchByName(name);
        ResponseDto responseDto = new ResponseDto("get call successful",book);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestParam int id,@RequestBody BookDto bookDto){
        Object book = bookService.update(id,bookDto);
        ResponseDto responseDto = new ResponseDto("Updated Successfully",book);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);

    }



    @PutMapping("/updateQuantity/{id}")
    public ResponseEntity<ResponseDto> updateQuantity(@PathVariable int id,@RequestBody BookDto bookDto){
        Book book = bookService.updateQuantity(id, bookDto.quantity);
        ResponseDto responseDto = new ResponseDto("Updated Successfully",book);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }



    @GetMapping("/sortAsc")
    public ResponseEntity<ResponseDto> sortAscending(){
        Object book = bookService.sortAsc();
        ResponseDto responseDto = new ResponseDto("sorted Successfully",book);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }



    @GetMapping("/sortDesc")
    public ResponseEntity<ResponseDto> sortDescending(){
        Object book = bookService.sortDesc();
        ResponseDto responseDto = new ResponseDto("sorted Successfully",book);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }

}
