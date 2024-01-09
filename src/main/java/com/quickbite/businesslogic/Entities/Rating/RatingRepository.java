package com.quickbite.businesslogic.Entities.Rating;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    @Override
    List<Rating> findAll();
}
