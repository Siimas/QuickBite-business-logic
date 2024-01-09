package com.quickbite.businesslogic.Dto.Staff;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTOMapper;
import com.quickbite.businesslogic.Dto.User.UserDTO;

public record StaffDTO (
        Long id,
        RestaurantDTO restaurant,
        UserDTO user
) {
}
