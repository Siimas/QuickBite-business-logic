package com.quickbite.businesslogic.Entities.Delivery;

import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
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
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum status;
    private LocalDateTime deliveredDate;
    @ManyToOne
    @JoinColumn(name = "deliveryman_id")
    private Deliveryman deliveryman;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

}
