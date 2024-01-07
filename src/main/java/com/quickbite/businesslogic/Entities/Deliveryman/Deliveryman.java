package com.quickbite.businesslogic.Entities.Deliveryman;

import com.quickbite.businesslogic.Entities.Delivery.Delivery;
import com.quickbite.businesslogic.Entities.Order.Order;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", unique = true)
//    private User user;
    @OneToMany(mappedBy = "deliveryman", cascade = CascadeType.ALL)
    private List<Delivery> deliveries;

}
