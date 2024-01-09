package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Food.FoodCreateDTO;
import com.quickbite.businesslogic.Dto.Food.FoodDTO;
import com.quickbite.businesslogic.Service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<FoodDTO>> getAllFoods() {
        return ResponseEntity.ok( foodService.getAllFood() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FoodDTO> getFood(@PathVariable Long id) {
        return ResponseEntity.ok( foodService.getFood(id) );
    }

    @PostMapping
    public ResponseEntity<String> createFood(@RequestBody FoodCreateDTO foodCreateDTO) {
        foodService.createFood(foodCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateFood(@PathVariable Long id, @RequestBody FoodCreateDTO foodCreateDTO) {
        foodService.updateFood(id, foodCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.ok("Success!");
    }
}
