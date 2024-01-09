package com.quickbite.businesslogic.Dto.Payment;

import com.quickbite.businesslogic.Dto.User.UserDTO;
import com.quickbite.businesslogic.Entities.Payment.PaymentStatusEnum;

import java.time.LocalDateTime;

public record PaymentCreateDTO(
        PaymentStatusEnum paymentStatus,
        LocalDateTime dateTime,
        LocalDateTime payedDateTime,
        double amount,
        Long userId,
        Long orderId
) {
}
