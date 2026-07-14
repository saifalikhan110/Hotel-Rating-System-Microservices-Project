package com.hotelRatingSystem.UserService.dto;


import com.hotelRatingSystem.UserService.entities.Ratings;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {


        private String id;
        private String name;
        private String email;
        private String about;

        @Transient
        private List<Ratings> ratingsList= new ArrayList<>();



}
