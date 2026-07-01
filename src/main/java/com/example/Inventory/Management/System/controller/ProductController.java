package com.example.Inventory.Management.System.controller;

import com.example.Inventory.Management.System.dto.ProductDTO;
import com.example.Inventory.Management.System.model.Product;
import com.example.Inventory.Management.System.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/")

public class ProductController {

    @Autowired
    private ProductService productService;
    private ProductDTO productDTO;

    @PostMapping("createproduct")
    public ResponseEntity<Product> createpoduct(@ModelAttribute ProductDTO productDTO){
        return productService.creatproduct(productDTO);
    }

    @PostMapping("createmanyproduct")
    public List<Product> createmanypoduct(@RequestBody List<ProductDTO> productDTOList){
        return productService.createmanyproduct(productDTOList);
    }

    @GetMapping("getallproduct")
    public List<Product> allproduct(){
        return productService.allproduct();
    }

    @GetMapping("getproductbyid/{id}")
    public Product geproductbyid(@PathVariable int id){
        return productService.getproductbyid(id);
    }

    @PostMapping("updateproduct/{id}")
    public ResponseEntity<Product> updateproduct(@PathVariable int id,@RequestBody ProductDTO productDTO){
        return productService.updateproduct(id,productDTO);
    }


    @DeleteMapping("deleteproduct/{id}")
    public void deleteproduct(@PathVariable int id){
        productService.deleteproduct(id);
    }
}
