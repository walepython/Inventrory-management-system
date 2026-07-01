package com.example.Inventory.Management.System.controller;

import com.example.Inventory.Management.System.model.Supplier;
import com.example.Inventory.Management.System.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier/")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("createsupplier")
    public Supplier createsupplier(@RequestBody Supplier supplier){
        return supplierService.createsupplier(supplier);
    }

    @GetMapping("allsupplier")
    public List<Supplier> allsupplier(){
        return supplierService.allsupplier();
    }
    @GetMapping("getsupplier/{id}")
    public Supplier getsupplier(@PathVariable int id){
        return supplierService.getsupplier(id);
    }

    @PostMapping("updatesupplier/{id}")
    public ResponseEntity<Supplier> updatesupplier(@PathVariable int id, @RequestBody Supplier supplier){
        return supplierService.updatesupplier(id,supplier);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deletebyid(@PathVariable int id){
        supplierService.deletebyid(id);
    }
    
}
