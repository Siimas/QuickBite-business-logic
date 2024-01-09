package com.quickbite.businesslogic.Dto.Payment;

import com.quickbite.businesslogic.Dto.Order.OrderDTOMapper;
import com.quickbite.businesslogic.Dto.Restaurant.RestaurantDTO;
import com.quickbite.businesslogic.Dto.User.UserDTOMapper;
import com.quickbite.businesslogic.Entities.Payment.Payment;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@AllArgsConstructor
public class PaymentDTOMapper implements Function<Payment, PaymentDTO> {

    private final UserDTOMapper userDTOMapper;
//    private final OrderDTOMapper orderDTOMapper;

    @Override
    public PaymentDTO apply(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getPaymentStatus(),
                payment.getDateTime(),
                payment.getPayedDateTime(),
                payment.getAmount(),
                userDTOMapper.apply(payment.getUser()),
                payment.getOrder().getId()
//                orderDTOMapper.apply(payment.getOrder())
        );
    }
}
