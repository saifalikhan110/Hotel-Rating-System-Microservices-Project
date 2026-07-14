package com.hotelRatingSystem.UserService.service;

import com.hotelRatingSystem.UserService.dto.UserRequest;
import com.hotelRatingSystem.UserService.dto.UserResponse;

import java.util.List;

public interface UserService {



    UserResponse createUser(UserRequest userRequest);

    UserResponse findByUserId(String userId);

    List<UserResponse> getAllUser();


}
