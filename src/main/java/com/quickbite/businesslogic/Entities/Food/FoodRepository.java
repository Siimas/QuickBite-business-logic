package com.quickbite.businesslogic.Entities.Food;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Long> {
    @Override
    List<Food> findAll();
}
