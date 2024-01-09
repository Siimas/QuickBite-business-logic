package com.quickbite.businesslogic.Dto.Order;

import com.quickbite.businesslogic.Dto.Delivery.DeliveryDTO;
import com.quickbite.businesslogic.Dto.Deliveryman.DeliverymanDTO;
import com.quickbite.businesslogic.Dto.Payment.PaymentDTO;
import com.quickbite.businesslogic.Dto.User.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public record OrderCreateDTO(
        String address,
        String details,
        LocalDateTime dateTime,
        Long deliverymanId,
        Long userId
) {
}
