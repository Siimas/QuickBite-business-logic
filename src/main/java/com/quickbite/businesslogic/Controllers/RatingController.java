package com.quickbite.businesslogic.Controllers;

import com.quickbite.businesslogic.Dto.Rating.RatingCreateDTO;
import com.quickbite.businesslogic.Dto.Rating.RatingDTO;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantCreateDTO;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<RatingDTO>> getAllRatings() {
        return ResponseEntity.ok( ratingService.getAllRatings() );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RatingDTO> getRating(@PathVariable Long id) {
        return ResponseEntity.ok( ratingService.getRating(id) );
    }

    @PostMapping
    public ResponseEntity<String> createRating(@RequestBody RatingCreateDTO ratingCreateDTO) {
        ratingService.createRating(ratingCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateRating(@PathVariable Long id, @RequestBody RatingCreateDTO ratingCreateDTO) {
        ratingService.updateRating(id, ratingCreateDTO);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok("Success!");
    }
}
