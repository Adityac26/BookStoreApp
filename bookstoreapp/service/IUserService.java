package com.bridgelabz.bookstoreapp.service;


import com.bridgelabz.bookstoreapp.dto.LoginDto;
import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.model.User;

import java.util.List;

public interface IUserService {

    public User register(UserDto userDto);

    public List<User> getAll();

    public User getById(int id);

    public void deleteById(int id);

    public User getByEmail(String email);


    public Object updateById(int id, UserDto userDto);


    public User forgotPassword(String email, String password);

    public Object updateByEmail(String email,UserDto userDto);

    public Object resetPassword(String email,String oldPassword, String newPassword);

    public Object login(LoginDto loginDto);

    public User post(UserDto userDto);
    public User getByToken(String token);
}
