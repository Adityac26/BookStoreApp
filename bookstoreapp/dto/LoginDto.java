package com.bridgelabz.bookstoreapp.dto;

public class LoginDto {
    public String email;
    public String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
