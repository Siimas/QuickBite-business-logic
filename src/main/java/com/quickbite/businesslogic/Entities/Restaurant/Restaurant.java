package com.quickbite.businesslogic.Entities.Restaurant;

import com.quickbite.businesslogic.GeoLocation;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
