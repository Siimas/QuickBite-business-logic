package com.quickbite.businesslogic.Entities.Payment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    @Override
    List<Payment> findAll();
}
