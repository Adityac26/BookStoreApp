package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

//import java.util.Date;

@Data
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)



    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    private Date DOB;
    private String password;





    public User(UserDto userDto){
        this.firstName= userDto.firstName;
        this.lastName = userDto.lastName;
        this.email = userDto.email;
        this.address = userDto.address;
        this.DOB = userDto.DOB;
        this.password = userDto.password;
    }


    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
