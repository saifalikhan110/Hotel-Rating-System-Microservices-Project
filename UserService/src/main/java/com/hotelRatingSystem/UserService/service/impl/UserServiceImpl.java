package com.hotelRatingSystem.UserService.service.impl;

import com.hotelRatingSystem.UserService.dto.UserRequest;
import com.hotelRatingSystem.UserService.dto.UserResponse;
import com.hotelRatingSystem.UserService.entities.Hotel;
import com.hotelRatingSystem.UserService.entities.Ratings;
import com.hotelRatingSystem.UserService.entities.User;
import com.hotelRatingSystem.UserService.exception.ResourceNotFound;
import com.hotelRatingSystem.UserService.external.service.HotelService;
import com.hotelRatingSystem.UserService.repositories.UserRepo;
import com.hotelRatingSystem.UserService.service.UserService;
import org.apache.juli.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = this.dtoToUser(userRequest);
        user.setId(UUID.randomUUID().toString());
        User save = userRepo.save(user);


        return this.userToDto(save);
    }

    @Override
    public UserResponse findByUserId(String userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("user", "userId", userId));

        // call rating service
        Ratings[] ratingsArray = restTemplate.getForObject(
                "http://RATING-SERVICE/rating/api/getRatingByUser/" + userId,
                Ratings[].class
        );

        List<Ratings> ratings = Arrays.asList(ratingsArray);

        ratings.stream().map(ratings1 -> {
        // api call for get Hotel
            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/api/getById/"+ratings1.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotelById(ratings1.getHotelId());

            //logger.info("response status code {} ",hotelResponseEntity.getStatusCode());

            ratings1.setHotel(hotel);
            return ratings1;

        }).toList();



        logger.info("Ratings: " + ratings);

        user.setRatingsList(ratings);

        // NOW convert after setting ratings
        UserResponse userResponse = this.userToDto(user);

        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> all = userRepo.findAll();

        List<UserResponse> responseList = all.stream()
                .map(user -> this.userToDto(user))
                .toList();

        return responseList;
    }


    public User dtoToUser(UserRequest userRequest){

        User user=modelMapper.map(userRequest,User.class);
        return user;
    }

    public UserResponse userToDto(User user){

        UserResponse userResponse=this.modelMapper.map(user,UserResponse.class);
        return userResponse;
    }

}
