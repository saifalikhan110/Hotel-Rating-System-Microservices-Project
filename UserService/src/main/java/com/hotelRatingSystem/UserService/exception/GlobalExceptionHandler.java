package com.hotelRatingSystem.UserService.exception;

import com.hotelRatingSystem.UserService.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {




    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFound resourceNotFound){


        String message = resourceNotFound.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(message).success(true).build();

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);


    }
}
