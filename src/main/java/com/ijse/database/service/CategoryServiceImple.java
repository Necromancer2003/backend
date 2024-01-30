package com.ijse.database.service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.database.entity.ItemCategory;
import com.ijse.database.repository.ItemCategoryRepository;

@Service
public class CategoryServiceImple implements CategoryService{
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategory(){
        return itemCategoryRepository.findAll();
    }

    @Override 
    public ItemCategory creatCategory(ItemCategory category){
        return itemCategoryRepository.save(category);
    }

    @Override
    public ItemCategory findCategoryById(Long id){
        return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategory updateCategory(Long id,ItemCategory category){
        ItemCategory existingitemCategory=itemCategoryRepository.findById(id).orElse(null);
        if(existingitemCategory != null){
            existingitemCategory.setName(category.getName());
            return itemCategoryRepository.save(existingitemCategory);
        }else{
            return null;
        }
    }

    @Override
    public ItemCategory deleteCategory(Long id) {
        ItemCategory itemCategory = itemCategoryRepository.findById(id).orElse(null);

        if (itemCategory != null) {
            itemCategoryRepository.deleteById(id);
            return itemCategory;
        } else {
            return null;
        }
    }
}
