package com.hotelRatingSystem.hotelService.service.impl;

import com.hotelRatingSystem.hotelService.dto.HotelRequest;
import com.hotelRatingSystem.hotelService.entities.Hotel;
import com.hotelRatingSystem.hotelService.exception.ResourceNotFoundException;
import com.hotelRatingSystem.hotelService.repositories.HotelRepo;
import com.hotelRatingSystem.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    private HotelRepo hotelRepo;


    @Override
    public Hotel createHotel(Hotel hotel) {

        String string = UUID.randomUUID().toString();
        hotel.setId(string);

        Hotel saved = hotelRepo.save(hotel);
        return saved;
    }

    @Override
    public List<Hotel> getAll() {

        List<Hotel> all = hotelRepo.findAll();

        return all;
    }

    @Override
    public Hotel getHotelById(String id) {

        Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel", "hotetId", id));
        return hotel;
    }
}
