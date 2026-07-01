package com.example.Inventory.Management.System.controller;

import com.example.Inventory.Management.System.model.IncomingOrder;
import com.example.Inventory.Management.System.service.IncomingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("incomingorder")
public class IncomingOrderController {

    @Autowired
    private IncomingOrderService incomingOrderService;

    @PostMapping("newincome")
    public IncomingOrder newincome(@RequestBody IncomingOrder incomingOrder){
        return incomingOrderService.newincome(incomingOrder);
    }
    @PostMapping("newincomes")
    public List<IncomingOrder> newincomes(@RequestBody List<IncomingOrder> incomingOrders){
        return incomingOrderService.newincomes(incomingOrders);
    }

    @GetMapping("getallincomingorder")
    public List<IncomingOrder> getallincome(){
        return incomingOrderService.getallincomingorder();
    }
    @GetMapping("getincomingorder/{id}")
    public IncomingOrder getincomingorder(@PathVariable int id){
        return incomingOrderService.getincomingorder(id);
    }

    @PostMapping("updateincomingorder/{id}")
    public ResponseEntity<IncomingOrder> updateincomingorder(@PathVariable int id, IncomingOrder incomingOrder){
        return incomingOrderService.updateincomingorder(id,incomingOrder);
    }

    @GetMapping("deleteincomingorder/{id}")
    public void deleteincomingorder(@PathVariable int id){
        incomingOrderService.deleteincomingorder(id);
    }

}
