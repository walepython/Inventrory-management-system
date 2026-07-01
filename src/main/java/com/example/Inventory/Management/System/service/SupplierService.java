package com.example.Inventory.Management.System.service;

import com.example.Inventory.Management.System.model.Supplier;
import com.example.Inventory.Management.System.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier createsupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public List<Supplier> allsupplier() {
        return supplierRepo.findAll();
    }

    public Supplier getsupplier(int id) {
        return supplierRepo.findById(id).get();
    }


    public ResponseEntity<Supplier> updatesupplier(int id, Supplier supplier) {

        if(supplierRepo.existsById(id)){
            Supplier sup = supplierRepo.findById(id).get();
            sup.setFirstName(supplier.getFirstName());
            sup.setLastName(supplier.getLastName());
            sup.setAge(supplier.getAge());
            sup.setAddress(supplier.getAddress());
            sup.setEmail(supplier.getEmail());
            sup.setPhoneNumber(supplier.getPhoneNumber());

            sup = supplierRepo.save(sup);
            return new ResponseEntity<>(sup, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
          }
    }

    public void deletebyid(int id) {
         supplierRepo.deleteById(id);
    }
}
