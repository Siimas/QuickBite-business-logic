package com.quickbite.businesslogic.Dto.Restaurant;

import com.quickbite.businesslogic.Dto.User.UserDTO;
import com.quickbite.businesslogic.Entities.Restaurant.GeoLocation;
import com.quickbite.businesslogic.Entities.User.User;

public record RestaurantDTO(
        Long id,
        String name,
        GeoLocation location,
        UserDTO owner
) {
}
