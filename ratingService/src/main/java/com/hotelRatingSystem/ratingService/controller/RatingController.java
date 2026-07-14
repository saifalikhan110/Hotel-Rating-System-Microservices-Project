package com.hotelRatingSystem.ratingService.controller;

import com.hotelRatingSystem.ratingService.entites.Rating;
import com.hotelRatingSystem.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating/api")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){


        return ResponseEntity.ok(ratingService.create(rating));

    }

    @GetMapping("/getAllRating")
    public  ResponseEntity<List<Rating>> getAllRating(){

        return ResponseEntity.ok(ratingService.getAllRatings());
    }


    @GetMapping("/getRatingByUser/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){


        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));

    } @GetMapping("/getRatingByHotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId){


        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));

    }

}
