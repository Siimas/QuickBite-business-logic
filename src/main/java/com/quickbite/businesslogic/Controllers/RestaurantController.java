package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.RestaurantDto;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Entities.Restaurant.RestaurantRepository;
import com.quickbite.businesslogic.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        Iterable<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok( restaurants );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant restaurant;

        try {
            restaurant = restaurantService.getRestaurant(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok( restaurant );
    }

    @PostMapping
    public ResponseEntity<String> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.createRestaurant(restaurantDto);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto) {
        try {
            restaurantService.updateRestaurant(id, restaurantDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Success!");
    }
}
