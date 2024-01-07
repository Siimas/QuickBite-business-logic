package com.quickbite.businesslogic.Entities.Order;

import com.quickbite.businesslogic.Entities.Delivery.Delivery;
import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
import com.quickbite.businesslogic.Entities.Payment.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "food_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String details;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "deliveryman_id")
    private Deliveryman deliveryman;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", unique = true)
    private Delivery delivery;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
