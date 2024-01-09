package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTO;
import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTOMapper;
import com.quickbite.businesslogic.Dto.Food.FoodCreateDTO;
import com.quickbite.businesslogic.Dto.Food.FoodDTO;
import com.quickbite.businesslogic.Dto.Food.FoodDTOMapper;
import com.quickbite.businesslogic.Entities.Delivery.DeliveryRepository;
import com.quickbite.businesslogic.Entities.Food.Food;
import com.quickbite.businesslogic.Entities.Food.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodDTOMapper foodDTOMapper;

    public List<FoodDTO> getAllFood() {
        return foodRepository.findAll()
                .stream()
                .map(foodDTOMapper)
                .collect(Collectors.toList());
    }

    public FoodDTO getFood(Long id) {
        return foodRepository.findById(id)
                .map(foodDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Food not found!"));
    }

    public void createFood(FoodCreateDTO FoodCreateDTO) {
    }

    public void updateFood(Long id, FoodCreateDTO FoodCreateDTO) {
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
