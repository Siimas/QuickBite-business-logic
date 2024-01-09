package com.quickbite.businesslogic.Entities.User;

import com.quickbite.businesslogic.Entities.Delivery.Delivery;
import com.quickbite.businesslogic.Entities.Deliveryman.Deliveryman;
import com.quickbite.businesslogic.Entities.Order.Order;
import com.quickbite.businesslogic.Entities.Payment.Payment;
import com.quickbite.businesslogic.Entities.Rating.Rating;
import com.quickbite.businesslogic.Entities.Restaurant.Restaurant;
import com.quickbite.businesslogic.Entities.Staff.Staff;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    @Email
    private String email;
    private int age;
    private String avaImageUrl;
    private String tag;
    private UserRole role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rating> ratings;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Staff> staffList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Deliveryman> deliverymanList;

    // todo: add the UserDetails implementation
}
