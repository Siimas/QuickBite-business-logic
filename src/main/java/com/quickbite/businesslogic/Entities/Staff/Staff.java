package com.quickbite.businesslogic.Entities.Staff;

import com.quickbite.businesslogic.Entities.Delivery.Delivery;
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
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
