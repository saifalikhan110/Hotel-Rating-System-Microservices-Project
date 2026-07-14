package com.hotelRatingSystem.ratingService.service.Impl;

import com.hotelRatingSystem.ratingService.entites.Rating;
import com.hotelRatingSystem.ratingService.repositories.RatingRepo;
import com.hotelRatingSystem.ratingService.service.RatingService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {

        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {

        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {


        return ratingRepo.findByHotelId(hotelId);
    }

}
