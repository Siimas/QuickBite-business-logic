package com.quickbite.businesslogic.Entities.Restaurant;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation {
    private double latitude;
    private double longitude;
}
