package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.LoginDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserDto userDto){
        User user = userService.register(userDto);
        ResponseDto responseDto= new ResponseDto("Registered successfully ",user);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    @GetMapping("getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable int id){
        User user = userService.getById(id);
        ResponseDto responseDto = new ResponseDto("Get call successful", user);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);

    }


    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<ResponseDto> getByEmailId(@PathVariable String email){
        User user = userService.getByEmail(email);
        ResponseDto responseDto = new ResponseDto("Get call successful", user);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);

    }



    @PutMapping("/updateById")
    public ResponseEntity<ResponseDto> update(@RequestParam int id, @RequestBody UserDto userDto){
        Object user= userService.updateById(id,userDto);
        ResponseDto responseDto = new ResponseDto("data updated",user);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);

    }


    @PutMapping("/updateByEmail/{email}")
    public ResponseEntity<ResponseDto> updateByEmail(@PathVariable String email, @RequestBody UserDto userDto){
        Object user= userService.updateByEmail(email,userDto);
        ResponseDto responseDto = new ResponseDto("User updated",user);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }


    @GetMapping("/getByToken/{token}")
    public ResponseEntity<ResponseDto> updateByEmail(@PathVariable String token) {
        User user = userService.getByToken(token);
        ResponseDto responseDto = new ResponseDto("get call successful",user);
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);

    }
    @PostMapping("/token")
    public ResponseEntity<ResponseDto> post(@RequestBody UserDto userDto){
        User user = userService.post(userDto);
        ResponseDto responseDto= new ResponseDto("Registered successfully ",user);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }


    @PutMapping("/forgotPass/{email}")
    public ResponseEntity<ResponseDto> forgotPassword(@PathVariable String email, @RequestBody UserDto userDto){
        User user = userService.forgotPassword(email, userDto.password);
        ResponseDto responseDto = new ResponseDto("Password changed successfully", user);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @PutMapping("/resetPassword")
    public ResponseEntity<ResponseDto> resetPassword(@RequestParam String email,@RequestParam String oldPass,
                                                     @RequestParam String newPassword){
        Object user = userService.resetPassword(email,oldPass,newPassword);
        ResponseDto responseDto = new ResponseDto("Password changed successfully", user);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable int id){
        userService.deleteById(id);
        ResponseDto responseDto = new ResponseDto("user deleted ","");
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }



    @GetMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto){
        Object user = userService.login(loginDto);
        ResponseDto responseDto = new ResponseDto("Login successful ",user);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
