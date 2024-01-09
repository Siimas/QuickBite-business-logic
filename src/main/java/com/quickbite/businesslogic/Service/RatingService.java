package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Rating.RatingCreateDTO;
import com.quickbite.businesslogic.Dto.Rating.RatingDTO;
import com.quickbite.businesslogic.Dto.Rating.RatingDTOMapper;
import com.quickbite.businesslogic.Entities.Rating.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final RatingDTOMapper ratingDTOMapper;

    public List<RatingDTO> getAllRatings() {
        return ratingRepository.findAll()
                .stream()
                .map(ratingDTOMapper)
                .collect(Collectors.toList());
    }

    public RatingDTO getRating(Long id) {
        return ratingRepository.findById(id)
                .map(ratingDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Rating not found!"));
    }

    public void createRating(RatingCreateDTO ratingCreateDTO) {
    }

    public void updateRating(Long id, RatingCreateDTO ratingCreateDTO) {
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
