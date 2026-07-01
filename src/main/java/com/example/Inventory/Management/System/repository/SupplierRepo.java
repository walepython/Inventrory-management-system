package com.example.Inventory.Management.System.repository;

import com.example.Inventory.Management.System.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {

}
