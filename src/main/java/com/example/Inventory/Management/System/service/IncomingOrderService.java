package com.example.Inventory.Management.System.service;

import com.example.Inventory.Management.System.model.IncomingOrder;
import com.example.Inventory.Management.System.model.Product;
import com.example.Inventory.Management.System.repository.IncomingOrderRepo;
import com.example.Inventory.Management.System.repository.ProductRepo;
import com.example.Inventory.Management.System.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomingOrderService {

    @Autowired
    private IncomingOrderRepo incomingOrderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    public IncomingOrder newincome(IncomingOrder incomingOrder) {
        Product product = productRepo.findById(incomingOrder.getProductId()).get();

        IncomingOrder incomingOrder2 = new IncomingOrder();
        incomingOrder2.setProductId(incomingOrder.getProductId());
        incomingOrder2.setSupplierId(incomingOrder.getSupplierId());
        incomingOrder2.setQuantitySupply(incomingOrder.getQuantitySupply());
        incomingOrder2.setUnitPrice(incomingOrder.getUnitPrice());
        incomingOrder2.setTotalPrice(incomingOrder.getQuantitySupply()*incomingOrder.getUnitPrice());
        product.setAvailableQuantity(
                product.getAvailableQuantity() + incomingOrder.getQuantitySupply()
        );
        productRepo.save(product);
        return incomingOrderRepo.save(incomingOrder2);
    }

    public List<IncomingOrder> newincomes(List<IncomingOrder> incomingOrders) {

        return incomingOrderRepo.saveAll(incomingOrders);
    }

    public List<IncomingOrder> getallincomingorder() {
        return incomingOrderRepo.findAll();
    }

    public IncomingOrder getincomingorder(int id) {
        return incomingOrderRepo.findById(id).get();
    }

    public ResponseEntity<IncomingOrder> updateincomingorder(int id, IncomingOrder incomingOrder) {
          Product product = productRepo.findById(incomingOrder.getProductId()).get();
        if(incomingOrderRepo.existsById(id)){
            IncomingOrder incomingOrder1 = incomingOrderRepo.findById(id).get();
            incomingOrder1.setQuantitySupply(incomingOrder.getQuantitySupply());
            incomingOrder1.setUnitPrice(incomingOrder.getUnitPrice());
            incomingOrder1.setProductId(incomingOrder.getProductId());
            incomingOrder1.setSupplierId(incomingOrder.getSupplierId());
            incomingOrder1.setTotalPrice(incomingOrder.getQuantitySupply()*incomingOrder.getUnitPrice());

            // Increase product quantity
            product.setAvailableQuantity(
                    product.getAvailableQuantity() + incomingOrder.getQuantitySupply()
            );

            productRepo.save(product);
            IncomingOrder saved = incomingOrderRepo.save(incomingOrder1);
            return new ResponseEntity<>(saved, HttpStatus.ACCEPTED);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void deleteincomingorder(int id) {
        incomingOrderRepo.deleteById(id);
        System.out.println("the incomingorder as been deleted");
    }
}
