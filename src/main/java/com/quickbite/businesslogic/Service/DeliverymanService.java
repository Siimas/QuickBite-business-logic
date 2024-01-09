package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanCreateDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTOMapper;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantCreateDTO;
import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
import com.quickbite.businesslogic.Entities.Deliveryman.DeliverymanRepository;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliverymanService {

    private final DeliverymanRepository deliverymanRepository;
    private final DeliverymanDTOMapper deliverymanDTOMapper;

    public List<DeliverymanDTO> getAllDeliveryman() {
        return deliverymanRepository.findAll()
                .stream()
                .map(deliverymanDTOMapper)
                .collect(Collectors.toList());
    }

    public DeliverymanDTO getDeliveryman(Long id) {
        return deliverymanRepository.findById(id)
                .map(deliverymanDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Restaurant not found!"));
    }

    public void createDeliveryman(DeliverymanCreateDTO deliverymanCreateDTO) {
    }

    public void updateDeliveryman(Long id, DeliverymanCreateDTO deliverymanCreateDTO) {
    }

    public void deleteDeliveryman(Long id) {
        deliverymanRepository.deleteById(id);
    }
}
