package com.quickbite.businesslogic.Dto.Deliveryman;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTOMapper;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTOMapper;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DeliverymanDTOMapper implements Function<Deliveryman, DeliverymanDTO> {

    private final RestaurantDTOMapper restaurantDTOMapper;
    private final UserDTOMapper userDTOMapper;
    private final DeliveryDTOMapper deliveryDTOMapper;

    @Override
    public DeliverymanDTO apply(Deliveryman deliveryman) {
        return new DeliverymanDTO(
                deliveryman.getId(),
                restaurantDTOMapper.apply(deliveryman.getRestaurant()),
                userDTOMapper.apply(deliveryman.getUser()),
                deliveryman.getDeliveries()
                        .stream()
                        .map(deliveryDTOMapper)
                        .collect(Collectors.toList())
        );
    }
}
