package com.example.Inventory.Management.System.controller;

import com.example.Inventory.Management.System.dto.OutgoingOrderDTO;
import com.example.Inventory.Management.System.model.OutgoingOrder;
import com.example.Inventory.Management.System.service.OutgoingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("outgoingorder")
public class OutgoingOrderController {

    @Autowired
    private OutgoingOrderService outgoingOrderService;


    private OutgoingOrderDTO outgoingOrderDTO;

    @PostMapping("newoutgoingorder")
    public OutgoingOrder newoutgoingorder(@RequestBody OutgoingOrderDTO outgoingOrderDTO){
        return outgoingOrderService.newoutgoingorder(outgoingOrderDTO);
    }

    @PostMapping("createmanyoutgoingorder")
    public List<OutgoingOrder> createmanyoutgoingorder(@RequestBody List<OutgoingOrderDTO> outgoingOrderDTOS){
        return outgoingOrderService.createmanyoutgoingorder(outgoingOrderDTOS);
    }

    @GetMapping("getalloutgoingorder")
    public List<OutgoingOrder> getalloutgoingorder(){
        return outgoingOrderService.getalloutgoingorder();
    }

    @GetMapping("getoutgoingorderbyid/{id}")
    public OutgoingOrder getoutgoingorderbyid(@PathVariable int id){
        return outgoingOrderService.getoutgoingorderbyid(id);
    }

    @PostMapping("updateoutgoingorder/{id}")
    public ResponseEntity<OutgoingOrder> updateoutgoingorder(@PathVariable int id, OutgoingOrderDTO outgoingOrderDTO){
        return outgoingOrderService.updateoutgoingorder(id,outgoingOrderDTO);
    }

    @DeleteMapping("deleteoutgoingorder/{id}")
    public void deleteoutgoingorder(@PathVariable int id){
      outgoingOrderService.deleteoutgoingorder(id);
    }
}
