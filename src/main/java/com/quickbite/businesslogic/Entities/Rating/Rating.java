package com.quickbite.businesslogic.Entities.Rating;

import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Entities.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime dateTime;
    @Enumerated(EnumType.ORDINAL)
    private ScoreEnum score;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
