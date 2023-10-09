package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.LoginDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.repository.UserRepo;
import com.bridgelabz.bookstoreapp.util.EmailSenderService;
import com.bridgelabz.bookstoreapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    EmailSenderService emailSender;


    @Override
    public User register(UserDto userDto){
        User user= new User(userDto);
         userRepo.save(user);
        emailSender.sendEmail(user.getEmail(), "user registered","User registerd successfully "+"User details "+user);
        return user;
    };


    @Override
    public User post(UserDto userDto){
        User user = new User(userDto);
        userRepo.save(user);

        String token= tokenUtil.createToken(user.getUserId());
        System.out.println(token);
        emailSender.sendEmail(user.getEmail(),"Registration done successfully","User has been added "+"Token : "+" http://localhost:8080/user/token "+token);
        return  user;
    }

    public User getByToken(String token) {
        int userId = tokenUtil.decodeToken(token);

        return userRepo.findById(userId).get();
    }



    @Override
    public List<User> getAll(){
        return userRepo.findAll();
    }

    @Override
    public User getById(int id){
        if (userRepo.existsById(id)) {
            return userRepo.findById(id).get();}
        return userRepo.findById(id).get();
    }

    @Override
    public User getByEmail(String email){
        User user =  userRepo.findUserByEmail(email);
        return user;
    }



    @Override
    public Object updateByEmail(String email, UserDto userDto) {
            User user = userRepo.findUserByEmail(email);
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setAddress(userDto.getAddress());
            user.setDOB(userDto.getDOB());
            user.setPassword(userDto.getPassword());

            User user1 = userRepo.save(user);
        emailSender.sendEmail(user.getEmail(), "user updated","User details updated successfully "+"User details "+user);
            ResponseDto responseDto = new ResponseDto("User updated successfully",user1);
            return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);


    }

    @Override
    public Object updateById(int id, UserDto userDto) {
        if (userRepo.existsById(id)) {
            User user = new User(userDto);
            user.setUserId(id);
            User user1 = userRepo.save(user);
            emailSender.sendEmail(user.getEmail(), "user updated","User details updated successfully "+"User details "+user);
            ResponseDto responseDto = new ResponseDto("Data updated", user1);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);

        } else {return "enter correct id";}

    }

    @Override
    public User forgotPassword(String email, String password){
        User user = userRepo.findByEmail(email);
        user.setPassword(password);
        emailSender.sendEmail(user.getEmail(), "Forgot password","Click on the link to set new password "+"Link: ");
        return userRepo.save(user);
    }


    public Object login(LoginDto loginDto) {
        User user = userRepo.findByEmail(loginDto.email);
        if (user.getPassword().equals(loginDto.password)){

            return "Login success";
        }
        else return "Enter correct email id";

    }

    @Override
    public void deleteById(int id) {

        userRepo.deleteById(id);
    }

    public Object resetPassword(String email,String oldPassword, String newPassword){
        User user = userRepo.findByEmail(email);
        if (oldPassword.equals(user.getPassword())){
            user.setPassword(newPassword);
            userRepo.save(user);
            emailSender.sendEmail(user.getEmail(), "password changed successfully","password changed successfully ");
            return true;
        }
        return false;
    }


}
