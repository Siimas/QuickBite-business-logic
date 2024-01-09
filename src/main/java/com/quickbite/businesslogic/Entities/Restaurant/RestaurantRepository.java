package com.quickbite.businesslogic.Entities.Restaurant;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Override
    List<Restaurant> findAll();
}
