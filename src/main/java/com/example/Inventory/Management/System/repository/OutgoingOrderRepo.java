package com.example.Inventory.Management.System.repository;

import com.example.Inventory.Management.System.model.OutgoingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingOrderRepo extends JpaRepository<OutgoingOrder,Integer> {
}
