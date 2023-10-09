package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.model.Cart;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> insert(@RequestBody CartDto cartDto){
        Cart cart = cartService.insert(cartDto);
        ResponseDto responseDto = new ResponseDto("Data inserted successfully", cart);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAll(){
        List<Cart> cart = cartService.getAll();
        ResponseDto responseDto = new ResponseDto("Get call successful", cart);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable int id){
        Optional<Cart> cart = cartService.getById(id);
        ResponseDto responseDto = new ResponseDto("get call successful", cart);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id){
        cartService.delete(id);
        ResponseDto responseDto = new ResponseDto("Deleted successfuly", " ");
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @PutMapping("/updateById")
    public ResponseEntity<ResponseDto> updateById(@RequestParam int id, @RequestBody CartDto cartDto){
        Cart cart =cartService.updateById(id, cartDto);
        ResponseDto responseDto = new ResponseDto("Data updated successfully", cart);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }




    @PutMapping("/updateQuantity/{id}")
    public ResponseEntity<ResponseDto> updateQuantity(@PathVariable int id, @RequestBody CartDto cartDto){
        Cart cart = cartService.updateQuantity(id, cartDto.quantity);
        ResponseDto responseDto = new ResponseDto("Quantity updated successfully", cart);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
