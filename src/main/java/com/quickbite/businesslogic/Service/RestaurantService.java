package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.RestaurantDto;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Entities.Restaurant.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Restaurant not found!"));
    }

    public void createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new
                Restaurant.builder()
                .name(restaurantDto.getName())
                .location(restaurantDto.getLocation())
                .build();

        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Long id, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurant not found!"));

        restaurant.setName(restaurantDto.getName());
        restaurant.setLocation(restaurantDto.getLocation());

        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
