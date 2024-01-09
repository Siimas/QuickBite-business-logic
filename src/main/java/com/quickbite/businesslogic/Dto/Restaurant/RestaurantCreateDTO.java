package com.quickbite.businesslogic.Dto.Restaurant;

import com.quickbite.businesslogic.Entities.Restaurant.GeoLocation;
import com.quickbite.businesslogic.Entities.User.User;
import lombok.Data;

public record RestaurantCreateDTO (
        String name,
        GeoLocation location,
        Long ownerId
) {

}
