package com.quickbite.businesslogic.Dto.Restaurant;

import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class RestaurantDTOMapper implements Function<Restaurant, RestaurantDTO> {

    private final UserDTOMapper userDTOMapper;

    @Override
    public RestaurantDTO apply(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getId(), 
                restaurant.getName(),
                restaurant.getLocation(),
                userDTOMapper.apply(restaurant.getOwner())
        );
    }

}