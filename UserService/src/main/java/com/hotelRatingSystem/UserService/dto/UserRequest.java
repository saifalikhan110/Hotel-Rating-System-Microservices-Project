package com.hotelRatingSystem.UserService.dto;


import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String email;
    private String about;
}
