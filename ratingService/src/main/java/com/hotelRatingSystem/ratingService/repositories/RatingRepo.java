package com.hotelRatingSystem.ratingService.repositories;

import com.hotelRatingSystem.ratingService.entites.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {

    // Custom  Finder Methods
    public List<Rating> findByUserId(String userId);
    public List<Rating> findByHotelId(String id);

}
