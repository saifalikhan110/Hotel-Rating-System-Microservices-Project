package com.hotelRatingSystem.hotelService.controller;

import com.hotelRatingSystem.hotelService.entities.Hotel;
import com.hotelRatingSystem.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel/api")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){


        Hotel hotel1 = hotelService.createHotel(hotel);

        return ResponseEntity.ok(hotel);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAll(){

        return ResponseEntity.ok(hotelService.getAll());
    }


    @GetMapping("/getById/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable String hotelId){

        return ResponseEntity.ok(hotelService.getHotelById(hotelId));

    }
}
