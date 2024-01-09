package com.quickbite.businesslogic.Entities.Restaurant;

import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
import com.quickbite.businesslogic.Entities.Food.Food;
import com.quickbite.businesslogic.Entities.Rating.Rating;
import com.quickbite.businesslogic.Entities.Staff.Staff;
import com.quickbite.businesslogic.Entities.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    private GeoLocation location;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Rating> ratings;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> foodList;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Deliveryman> deliverymanList;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Staff> staffList;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

}
