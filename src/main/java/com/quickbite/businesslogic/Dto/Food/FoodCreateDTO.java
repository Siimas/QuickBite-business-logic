package com.quickbite.businesslogic.Dto.Food;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;

public record FoodCreateDTO(
        String name,
        String description,
        String imageUrl,
        Long restaurantId
) {
}
