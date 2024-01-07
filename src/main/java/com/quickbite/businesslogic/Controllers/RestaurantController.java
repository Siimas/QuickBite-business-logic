package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.RestaurantDto;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        Iterable<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok( restaurants );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return ResponseEntity.ok( restaurant );
    }

    @PostMapping
    public ResponseEntity<String> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.createRestaurant(restaurantDto);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id, @RequestBody @Validated RestaurantDto restaurantDto) {
        restaurantService.updateRestaurant(id, restaurantDto);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("Success!");
    }
}
