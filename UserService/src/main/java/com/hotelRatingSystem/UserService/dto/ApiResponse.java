package com.hotelRatingSystem.UserService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {


    private String message;
    private Boolean success;
}
