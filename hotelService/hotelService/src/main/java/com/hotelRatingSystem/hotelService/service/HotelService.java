package com.hotelRatingSystem.hotelService.service;

import com.hotelRatingSystem.hotelService.dto.HotelRequest;
import com.hotelRatingSystem.hotelService.entities.Hotel;

import java.util.List;

public interface HotelService {



    public Hotel createHotel(Hotel hotel);

    public List<Hotel> getAll();

    public Hotel getHotelById(String id);

}
