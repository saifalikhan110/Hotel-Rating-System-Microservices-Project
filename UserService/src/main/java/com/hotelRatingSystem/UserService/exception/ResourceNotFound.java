package com.hotelRatingSystem.UserService.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFound extends RuntimeException{



    String resourceName;
    String fieldName;
    String fieldValue;



    public ResourceNotFound(String resourceName, String fieldName, String fieldValue) {

        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


    public ResourceNotFound(String fieldName){

        super(String.format("%s note found",fieldName));
        this.fieldName=fieldName;
    }
}
