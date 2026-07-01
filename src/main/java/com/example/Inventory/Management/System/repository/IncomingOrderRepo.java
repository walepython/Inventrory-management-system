package com.example.Inventory.Management.System.repository;

import com.example.Inventory.Management.System.model.IncomingOrder;
import org.hibernate.query.criteria.JpaDerivedRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingOrderRepo extends JpaRepository<IncomingOrder,Integer> {

}
