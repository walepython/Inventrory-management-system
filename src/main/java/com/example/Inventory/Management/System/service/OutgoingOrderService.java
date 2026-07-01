package com.example.Inventory.Management.System.service;

import com.example.Inventory.Management.System.dto.OutgoingOrderDTO;
import com.example.Inventory.Management.System.model.OutgoingOrder;
import com.example.Inventory.Management.System.model.Product;
import com.example.Inventory.Management.System.repository.OutgoingOrderRepo;
import com.example.Inventory.Management.System.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OutgoingOrderService {

    @Autowired
    private OutgoingOrderRepo outgoingOrderRepo;

    @Autowired
    private ProductRepo productRepo;

    public OutgoingOrder newoutgoingorder(OutgoingOrderDTO outgoingOrderDTO) {
        Product product = productRepo.findById(outgoingOrderDTO.getProductId()).get();

        if(product.getAvailableQuantity() < outgoingOrderDTO.getQuantityOrder()){
            throw new RuntimeException("Not enough stock available");
        }
        OutgoingOrder outgoingOrder = new OutgoingOrder();
        outgoingOrder.setProductId(outgoingOrderDTO.getProductId());
        outgoingOrder.setQuantityOrder(outgoingOrderDTO.getQuantityOrder());
        outgoingOrder.setTotalPriceBeforeDiscount(product.getUnitPrice() * outgoingOrderDTO.getQuantityOrder());
        outgoingOrder.setDiscount(outgoingOrderDTO.getDiscount());
        outgoingOrder.setTotalPriceAfterDiscount(product.getUnitPrice() * outgoingOrderDTO.getQuantityOrder()- outgoingOrderDTO.getDiscount());
        product.setAvailableQuantity(
                product.getAvailableQuantity() - outgoingOrderDTO.getQuantityOrder()
        );
        productRepo.save(product);
        return outgoingOrderRepo.save(outgoingOrder);
    }



    public List<OutgoingOrder> getalloutgoingorder() {
        return outgoingOrderRepo.findAll();
    }

    public OutgoingOrder getoutgoingorderbyid(int id) {
        return outgoingOrderRepo.findById(id).get();
    }


    public List<OutgoingOrder> createmanyoutgoingorder(List<OutgoingOrderDTO> outgoingOrderDTOS) {
        List<OutgoingOrder> outgoingOrders = new ArrayList<>();
         for(OutgoingOrderDTO outgoingOrderDTO : outgoingOrderDTOS){
             Product product = productRepo.findById(outgoingOrderDTO.getProductId()).get();
             if (product.getAvailableQuantity() < outgoingOrderDTO.getQuantityOrder()){
                 throw new RuntimeException("Not enough stock available");
             }
             OutgoingOrder outgoingOrder = new OutgoingOrder();
             outgoingOrder.setProductId(outgoingOrderDTO.getProductId());
             outgoingOrder.setQuantityOrder(outgoingOrderDTO.getQuantityOrder());
             outgoingOrder.setTotalPriceBeforeDiscount(product.getUnitPrice()*outgoingOrderDTO.getQuantityOrder());
             outgoingOrder.setDiscount(outgoingOrderDTO.getDiscount());
             outgoingOrder.setTotalPriceAfterDiscount(product.getUnitPrice() * outgoingOrderDTO.getQuantityOrder() - outgoingOrderDTO.getDiscount());
             outgoingOrders.add(outgoingOrder);

             product.setAvailableQuantity(
                     product.getAvailableQuantity() - outgoingOrderDTO.getQuantityOrder()
             );
             productRepo.save(product);
         }
         return outgoingOrderRepo.saveAll(outgoingOrders);
    }

    public ResponseEntity<OutgoingOrder> updateoutgoingorder(int id, OutgoingOrderDTO outgoingOrderDTO) {
        Product product = productRepo.findById(id).get();
        if(outgoingOrderRepo.existsById(id)){
          OutgoingOrder outgoingOrder = outgoingOrderRepo.findById(id).get();
          outgoingOrder.setProductId(outgoingOrderDTO.getProductId());
          outgoingOrder.setQuantityOrder(outgoingOrderDTO.getQuantityOrder());
          outgoingOrder.setTotalPriceBeforeDiscount(outgoingOrderDTO.getQuantityOrder() * product.getUnitPrice());
          outgoingOrder.setDiscount(outgoingOrderDTO.getDiscount());
          outgoingOrder.setTotalPriceAfterDiscount(outgoingOrderDTO.getQuantityOrder() * product.getUnitPrice() - outgoingOrderDTO.getDiscount());
          product.setAvailableQuantity(
                    product.getAvailableQuantity() - outgoingOrderDTO.getQuantityOrder()
            );
            productRepo.save(product);
          OutgoingOrder outgoingOrder1 = outgoingOrderRepo.save(outgoingOrder);
          return new ResponseEntity<>(outgoingOrder1, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);

    }

    public void deleteoutgoingorder(int id) {
        outgoingOrderRepo.deleteById(id);
    }
}
