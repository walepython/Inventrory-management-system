package com.example.Inventory.Management.System.repository;

import com.example.Inventory.Management.System.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StaffRepo extends JpaRepository<Staff,Integer> {
    Optional<Staff> findByEmail(String email);

    boolean existsByEmail(String email);
}
