package com.quickbite.businesslogic.Dto.Food;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;

public record FoodDTO (
        Long id,
        String name,
        String description,
        String imageUrl,
        RestaurantDTO restaurant
) {
}
