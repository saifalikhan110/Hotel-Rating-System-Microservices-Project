package com.hotelRatingSystem.UserService.controller;

import com.hotelRatingSystem.UserService.dto.UserRequest;
import com.hotelRatingSystem.UserService.dto.UserResponse;
import com.hotelRatingSystem.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){

        UserResponse user = userService.createUser(userRequest);


        return new ResponseEntity<UserResponse>(user,HttpStatus.CREATED);

    }

    @GetMapping("/getUser/{userId}")
    public  ResponseEntity<UserResponse> findUserById(@PathVariable("userId") String userid){


        return ResponseEntity.ok(userService.findByUserId(userid));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAllUsers(){



        return ResponseEntity.ok(this.userService.getAllUser());
    }
}
