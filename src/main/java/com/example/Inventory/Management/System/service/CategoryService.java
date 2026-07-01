package com.example.Inventory.Management.System.service;

import com.example.Inventory.Management.System.model.Category;
import com.example.Inventory.Management.System.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category createcategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> allcategory() {
        return categoryRepo.findAll();
    }

    public Category getcategory(int id) {
        return categoryRepo.findById(id).get();
    }

    public ResponseEntity<Category> updatecategory(int id, Category category) {
        if(categoryRepo.existsById(id)){
            Category cat = categoryRepo.findById(id).get();
            cat.setName(category.getName());
            cat = categoryRepo.save(cat);
            return new ResponseEntity<>(cat, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }
}
