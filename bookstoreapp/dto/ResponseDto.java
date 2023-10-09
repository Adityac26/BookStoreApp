package com.bridgelabz.bookstoreapp.dto;

public class ResponseDto {

    public String message;
    public  Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
