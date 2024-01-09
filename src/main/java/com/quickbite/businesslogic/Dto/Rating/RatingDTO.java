package com.quickbite.businesslogic.Dto.Rating;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Dto.User.UserDTO;
import com.quickbite.businesslogic.Entities.Rating.ScoreEnum;

import java.time.LocalDateTime;

public record RatingDTO (
         Long id,
         String description,
         LocalDateTime dateTime,
         ScoreEnum score,
         RestaurantDTO restaurant,
         UserDTO user
) {

}
