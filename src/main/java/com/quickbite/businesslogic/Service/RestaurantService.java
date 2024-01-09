package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantCreateDTO;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Entities.Restaurant.RestaurantRepository;
import com.quickbite.businesslogic.Entities.User.User;
import com.quickbite.businesslogic.Entities.User.UserRepository;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantDTOMapper restaurantDTOMapper;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantDTOMapper)
                .collect(Collectors.toList());
    }

    public RestaurantDTO getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurantDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Restaurant not found!"));
    }

    public void createRestaurant(RestaurantCreateDTO restaurantDto) {
        Long userId = restaurantDto.ownerId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found!"));

        Restaurant restaurant =
                Restaurant.builder()
                .name(restaurantDto.name())
                .location(restaurantDto.location())
                .owner(user)
                .build();

        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Long id, RestaurantCreateDTO restaurantCreateDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurant not found!"));

        restaurant.setName(restaurantCreateDTO.name());
        restaurant.setLocation(restaurantCreateDTO.location());
        //restaurant.setOwner(restaurantCreateDTO.ownerId());

        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
