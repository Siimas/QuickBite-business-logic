package com.quickbite.businesslogic.Dto.Rating;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTOMapper;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import com.quickbite.businesslogic.Entities.Rating.Rating;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class RatingDTOMapper implements Function<Rating, RatingDTO> {

    private final RestaurantDTOMapper restaurantDTOMapper;
    private final UserDTOMapper userDTOMapper;

    @Override
    public RatingDTO apply(Rating rating) {
        return new RatingDTO(
                rating.getId(),
                rating.getDescription(),
                rating.getDateTime(),
                rating.getScore(),
                restaurantDTOMapper.apply(rating.getRestaurant()),
                userDTOMapper.apply(rating.getUser())
        );
    }
}
