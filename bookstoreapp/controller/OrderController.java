package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.model.OrderData;
import com.bridgelabz.bookstoreapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;



    @PostMapping("/insert/{userId}")
    public ResponseEntity<ResponseDto> insert(@PathVariable int userId,@RequestBody OrderDto orderDto){
        Object orderData = orderService.insert(userId,orderDto);
        ResponseDto responseDto = new ResponseDto("Data inserted successfully", orderData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @GetMapping ("/getAll")
    public ResponseEntity<ResponseDto> getAll(){
        List<OrderData> orderData = orderService.getAll();
        ResponseDto responseDto = new ResponseDto("Get call successfull", orderData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @GetMapping ("/getById/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable Long id){
        Optional<OrderData> orderData = orderService.getById(id);
        ResponseDto responseDto = new ResponseDto("Get call successfull", orderData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id){
        orderService.delete(id);
        ResponseDto responseDto = new ResponseDto("Deleted successfully", " ");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @PutMapping("update")
    public ResponseEntity<ResponseDto> updateById(@RequestParam Long orderId, @RequestBody OrderDto orderDto){
        OrderData orderData = orderService.updateById(orderId,orderDto);
        ResponseDto responseDto = new ResponseDto("Order updated successfully", orderData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<ResponseDto> cancelOrder(@PathVariable Long orderId){
        Object orderData = orderService.cancelOrder(orderId);
        ResponseDto responseDto = new ResponseDto("Order canceled ", null);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
