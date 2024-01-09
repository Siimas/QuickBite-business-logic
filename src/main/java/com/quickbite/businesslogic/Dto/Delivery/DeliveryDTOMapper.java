package com.quickbite.businesslogic.Dto.Delivery;

import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTOMapper;
import com.quickbite.businesslogic.Dto.Order.OrderDTOMapper;
import com.quickbite.businesslogic.Entities.Delivery.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class DeliveryDTOMapper implements Function<Delivery, DeliveryDTO> {

//    private final DeliverymanDTOMapper deliverymanDTOMapper;
//    private final OrderDTOMapper orderDTOMapper;

    @Override
    public DeliveryDTO apply(Delivery delivery) {
        return new DeliveryDTO(
                delivery.getId(),
                delivery.getStatus(),
                delivery.getDeliveredDate(),
//              deliverymanDTOMapper.apply(delivery.getDeliveryman()),
//              orderDTOMapper.apply(delivery.getOrder())
                delivery.getOrder().getId()

        );
    }
}
