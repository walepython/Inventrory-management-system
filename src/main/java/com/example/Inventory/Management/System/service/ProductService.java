package com.example.Inventory.Management.System.service;

import com.example.Inventory.Management.System.dto.EmailDetails;
import com.example.Inventory.Management.System.dto.ProductDTO;
import com.example.Inventory.Management.System.model.Category;
import com.example.Inventory.Management.System.model.Product;
import com.example.Inventory.Management.System.repository.CategoryRepo;
import com.example.Inventory.Management.System.repository.ProductRepo;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private FileStorageService fileStorageService;



    public ResponseEntity<Product> creatproduct(ProductDTO productDTO) {
       Product products = new Product();
       products.setName(productDTO.getName());
       products.setCategory(productDTO.getCategory());
       products.setAvailableQuantity(productDTO.getAvailableQuantity());
       products.setUnitPrice(productDTO.getUnitPrice());
       products.setTotalPrice(productDTO.getUnitPrice()*productDTO.getAvailableQuantity());
        try {
            String imageName =
                    fileStorageService.saveFile(productDTO.getImage());

            products.setImageUrl(imageName);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed");
        }


        products = productRepo.save(products);

        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }

    public List<Product> allproduct() {
        return productRepo.findAll();
    }

    public Product getproductbyid(int id) {
        return productRepo.findById(id).get();
    }

    public ResponseEntity<Product> updateproduct(int id, ProductDTO productDTO) {
        if(productRepo.existsById(id)){
            Product prud =  productRepo.findById(id).get();
            Category category = categoryRepo.findById(productDTO.getCategory().getId()).get();
            prud.setName(productDTO.getName());
            prud.setCategory(category);
            prud.setAvailableQuantity(productDTO.getAvailableQuantity());
            prud.setUnitPrice(productDTO.getUnitPrice());
            prud.setTotalPrice(productDTO.getUnitPrice()*productDTO.getAvailableQuantity());

            prud = productRepo.save(prud);
            categoryRepo.save(category);
            return new ResponseEntity<>(prud,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void deleteproduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> createmanyproduct(List<ProductDTO> productDTOList) {
        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOList) {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setCategory(productDTO.getCategory());
            product.setAvailableQuantity(productDTO.getAvailableQuantity());
            product.setUnitPrice(productDTO.getUnitPrice());
            product.setTotalPrice(productDTO.getUnitPrice() * productDTO.getAvailableQuantity());
            products.add(product);
        }

        return productRepo.saveAll(products);
    }
}
