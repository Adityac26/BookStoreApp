package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    public Cart insert(CartDto cartDto);

    public List<Cart> getAll();

    public Optional<Cart> getById(int id);

    public void delete(int id);

    public Cart updateById(int id, CartDto cartDto);

    public Cart updateQuantity(int id, int quantity);
}
