package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Restaurant.RestaurantCreateDTO;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    // TODO: ADD DTO FIELD VALIDATION

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        return ResponseEntity.ok( restaurantService.getAllRestaurants() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok( restaurantService.getRestaurant(id) );
    }

    @PostMapping
    public ResponseEntity<String> createRestaurant(@RequestBody RestaurantCreateDTO restaurantCreateDTO) {
        restaurantService.createRestaurant(restaurantCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantCreateDTO restaurantCreateDTO) {
        restaurantService.updateRestaurant(id, restaurantCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("Success!");
    }
}
