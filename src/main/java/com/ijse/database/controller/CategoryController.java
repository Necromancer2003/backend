package com.ijse.database.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.database.entity.ItemCategory;
import com.ijse.database.service.CategoryService;


@RestController
@CrossOrigin(origins="*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categoriesal")
    public List<ItemCategory> getAllCategorise(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/categories")
    public ItemCategory createCategory(@RequestBody ItemCategory category){
        return categoryService.creatCategory(category);
    }

    @GetMapping("/categories/{id}")
    public ItemCategory getCategoryById(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public ItemCategory updateCategory(@PathVariable Long id,@RequestBody ItemCategory category){
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/categories/{id}")
    public ItemCategory deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);

    }

}
