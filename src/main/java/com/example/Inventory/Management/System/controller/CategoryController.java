package com.example.Inventory.Management.System.controller;


import com.example.Inventory.Management.System.model.Category;
import com.example.Inventory.Management.System.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("createcategory")
    public Category createcategory(@RequestBody Category category){
        return categoryService.createcategory(category);
    }

    @GetMapping("allcategory")
    public List<Category> allcategory(){
        return categoryService.allcategory();
    }

    @GetMapping("getcategory/{id}")
    public Category getcategory(@PathVariable int id){
        return categoryService.getcategory(id);
    }
    @PostMapping("updatecategory/{id}")
    public ResponseEntity<Category> updatecategory(@PathVariable int id,@RequestBody Category category){
        return categoryService.updatecategory(id,category);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deleteById(@PathVariable int id){
        categoryService.deleteById(id);
    }

}
