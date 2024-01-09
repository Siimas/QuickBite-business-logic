package com.quickbite.businesslogic.Service;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryCreateDTO;
import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTO;
import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTOMapper;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTOMapper;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantCreateDTO;
import com.quickbite.businesslogic.Entities.Delivery.DeliveryRepository;
import com.quickbite.businesslogic.Entities.Deliveryman.DeliverymanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryDTOMapper deliveryDTOMapper;

    public List<DeliveryDTO> getAllDelivery() {
        return deliveryRepository.findAll()
                .stream()
                .map(deliveryDTOMapper)
                .collect(Collectors.toList());
    }

    public DeliveryDTO getDelivery(Long id) {
        return deliveryRepository.findById(id)
                .map(deliveryDTOMapper)
                .orElseThrow(() -> new NoSuchElementException("Restaurant not found!"));
    }

    public void createDelivery(DeliveryCreateDTO deliveryCreateDTO) {
    }

    public void updateDelivery(Long id, DeliveryCreateDTO deliveryCreateDTO) {
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
