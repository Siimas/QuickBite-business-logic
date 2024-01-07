package com.quickbite.businesslogic.Entities.Payment;

import com.quickbite.businesslogic.Entities.Order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    private LocalDateTime dateTime;
    private LocalDateTime payedDateTime;
    private double amount;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
