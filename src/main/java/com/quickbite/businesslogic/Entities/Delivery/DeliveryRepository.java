package com.quickbite.businesslogic.Entities.Delivery;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    @Override
    List<Delivery> findAll();
}
