package com.quickbite.businesslogic.Dto.Delivery;

import com.quickbite.businesslogic.Entities.Delivery.DeliveryStatusEnum;

import java.time.LocalDateTime;

public record DeliveryDTO(
        Long id,
        DeliveryStatusEnum status,
        LocalDateTime deliveredDate,
        Long deliverymanId
) {
}
