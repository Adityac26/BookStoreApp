package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long orderId;

    private int userId;

    private int bookId;

    private LocalDate date= LocalDate.now();

    private int totalPrice;

    private int quantity;

    private String address;

    boolean cancel;




    public OrderData(OrderDto orderDto){
        this.userId= orderDto.userId;
        this.bookId= orderDto.bookId;
        this.date= orderDto.date;
        this.totalPrice= orderDto.totalPrice;
        this.quantity = orderDto.quantity;
        this.address = orderDto.address;
    }

    public OrderData() {

    }

}
