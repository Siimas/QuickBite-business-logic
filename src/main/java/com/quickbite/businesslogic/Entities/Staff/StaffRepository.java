package com.quickbite.businesslogic.Entities.Staff;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff, Long> {
    @Override
    List<Staff> findAll();
}
