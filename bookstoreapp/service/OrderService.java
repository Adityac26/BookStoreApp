package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.OrderDto;
import com.bridgelabz.bookstoreapp.model.OrderData;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.repository.OrderRepo;
import com.bridgelabz.bookstoreapp.repository.UserRepo;
import com.bridgelabz.bookstoreapp.util.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    EmailSenderService emailSender;

    public Object insert(int id, OrderDto orderDto){
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            User user1 = user.get();
            OrderData orderData = new OrderData(orderDto);
            orderRepo.save(orderData);
        emailSender.sendEmail(user1.getEmail(),"order placed","Order placed successfully");
            return orderData;

        }
        else {return "Can not place order";}

    }


    public List<OrderData> getAll(){
        return orderRepo.findAll();
    }



    public Optional<OrderData> getById(Long id){
        return orderRepo.findById(id);
    }



    public void delete(Long id){
        orderRepo.deleteById(id);
    }



    public OrderData updateById(Long orderId, OrderDto orderDto){
        OrderData orderData = new OrderData(orderDto);
        orderData.setOrderId(orderId);
        OrderData orderData1= orderRepo.save(orderData);
        return  orderData1;

    }



    public Object cancelOrder(Long orderId){
        Optional<OrderData> orderData = orderRepo.findById(orderId);
        if (orderData.isPresent()){
            OrderData orderData1 = orderData.get();
            orderRepo.delete(orderData1);
            return "Order canceled";
        }
        else return "Order id not found";
    }
}
