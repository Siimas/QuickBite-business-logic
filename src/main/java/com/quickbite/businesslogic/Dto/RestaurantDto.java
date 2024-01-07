package com.quickbite.businesslogic.Dto;

import com.quickbite.businesslogic.Entities.Restaurant.GeoLocation;
import lombok.Data;

@Data
public class RestaurantDto {
    private String name;
    private GeoLocation location;
}
