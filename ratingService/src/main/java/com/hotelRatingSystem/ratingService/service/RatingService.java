package com.hotelRatingSystem.ratingService.service;

import com.hotelRatingSystem.ratingService.entites.Rating;

import java.util.List;

public interface RatingService {


    public Rating create(Rating rating);

    public List<Rating> getAllRatings();

    public List<Rating> getRatingByUserId(String userId);

    public List<Rating> getRatingByHotelId(String hotelId);
}
