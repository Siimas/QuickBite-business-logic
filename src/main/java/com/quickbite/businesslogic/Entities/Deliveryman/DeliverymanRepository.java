package com.quickbite.businesslogic.Entities.Deliveryman;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliverymanRepository extends CrudRepository<Deliveryman, Long> {
    @Override
    List<Deliveryman> findAll();
}
