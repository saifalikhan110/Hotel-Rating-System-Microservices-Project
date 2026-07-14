package com.hotelRatingSystem.hotelService.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private String message;
    private Boolean success;
}
