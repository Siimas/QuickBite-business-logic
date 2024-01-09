package com.quickbite.businesslogic.Dto.Food;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTOMapper;
import com.quickbite.businesslogic.Entities.Food.Food;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class FoodDTOMapper implements Function<Food, FoodDTO> {

    private final RestaurantDTOMapper restaurantDTOMapper;

    @Override
    public FoodDTO apply(Food food) {
        return new FoodDTO(
                food.getId(),
                food.getName(),
                food.getDescription(),
                food.getImageUrl(),
                restaurantDTOMapper.apply(food.getRestaurant())
        );
    }
}
