package com.hotelRatingSystem.hotelService.repositories;

import com.hotelRatingSystem.hotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
}
