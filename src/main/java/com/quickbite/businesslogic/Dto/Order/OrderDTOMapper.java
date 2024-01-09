package com.quickbite.businesslogic.Dto.Order;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTOMapper;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTOMapper;
import com.quickbite.businesslogic.Dto.Payment.PaymentDTOMapper;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import com.quickbite.businesslogic.Entities.Order.Order;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderDTOMapper implements Function<Order, OrderDTO> {

    private final DeliveryDTOMapper deliveryDTOMapper;
    private final DeliverymanDTOMapper deliverymanDTOMapper;
    private final PaymentDTOMapper paymentDTOMapper;
    private final UserDTOMapper userDTOMapper;

    @Override
    public OrderDTO apply(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getAddress(),
                order.getDetails(),
                order.getDateTime(),
                deliverymanDTOMapper.apply(order.getDeliveryman()),
                order.getPayments()
                        .stream()
                        .map(paymentDTOMapper)
                        .collect(Collectors.toList()),
                deliveryDTOMapper.apply(order.getDelivery()),
                userDTOMapper.apply(order.getUser())
        );
    }
}
