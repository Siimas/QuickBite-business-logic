package com.quickbite.businesslogic.Entities.Restaurant;

import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
import com.quickbite.businesslogic.Entities.Food.Food;
import com.quickbite.businesslogic.Entities.Rating.Rating;
import com.quickbite.businesslogic.Entities.Staff.Staff;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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

    public static class builder {
        private final Restaurant restaurant;

        public builder(){
            this.restaurant = new Restaurant();
        }

        public builder name(String name) {
            this.restaurant.setName(name);
            return this;
        }

        public builder location(GeoLocation location) {
            this.restaurant.setLocation(location);
            return this;
        }

        public Restaurant build() {
            return this.restaurant;
        }
    }

}
