package com.quickbite.businesslogic.Dto.Payment;

import com.quickbite.businesslogic.Dto.Order.OrderDTO;
import com.quickbite.businesslogic.Dto.User.UserDTO;
import com.quickbite.businesslogic.Entities.Payment.PaymentStatusEnum;

import java.time.LocalDateTime;

public record PaymentDTO(
        Long id,
        PaymentStatusEnum paymentStatus,
        LocalDateTime dateTime,
        LocalDateTime payedDateTime,
        double amount,
        UserDTO user,
//        OrderDTO order
        Long orderId
) {
}
