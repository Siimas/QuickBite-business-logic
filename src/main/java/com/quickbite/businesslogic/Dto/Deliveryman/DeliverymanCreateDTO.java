package com.quickbite.businesslogic.Dto.Deliveryman;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTO;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Dto.User.UserDTO;

import java.util.List;

public record DeliverymanCreateDTO(
        Long restaurantId,
        Long userId
) {
}
